/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author aluno
 */
public class Goomba {

    //private Texture textura;
    private TextureRegion[][] quadrosDaAnimacao;
    private Vector2 posicao;
    private Animation atual, andarPraCima, andarPraBaixo, andarPraEsquerda,andarPraDireita;
    private float tempoDaAnimacao;

    public float getPosicaoX() {
        return this.posicao.x;
    }

    public float getPosicaoY() {
        return this.posicao.y;
    }

    /*public Texture getTextura() {
        return this.textura;
    }*/

    public Goomba(Texture spriteSheet) {
        quadrosDaAnimacao = TextureRegion.split(spriteSheet, 21, 24);
        posicao = new Vector2();
        posicao.x = 30;
        posicao.y = 10;
        andarPraBaixo = new Animation(0.1f,
                quadrosDaAnimacao[0][0], // 1ª linha, 1ª coluna
                quadrosDaAnimacao[0][1], // idem, 2ª coluna
                quadrosDaAnimacao[0][2],
                quadrosDaAnimacao[0][3],
                quadrosDaAnimacao[0][4]);
        andarPraBaixo.setPlayMode(PlayMode.LOOP_PINGPONG);
        andarPraDireita = new Animation(0.1f,
                quadrosDaAnimacao[1][0], // 1ª linha, 1ª coluna
                quadrosDaAnimacao[1][1], // idem, 2ª coluna
                quadrosDaAnimacao[1][2],
                quadrosDaAnimacao[1][3],
                quadrosDaAnimacao[1][4]);
        andarPraDireita.setPlayMode(PlayMode.LOOP_PINGPONG);
         andarPraCima = new Animation(0.1f,
                quadrosDaAnimacao[2][0], // 1ª linha, 1ª coluna
                quadrosDaAnimacao[2][1], // idem, 2ª coluna
                quadrosDaAnimacao[2][2],
                quadrosDaAnimacao[2][3],
                quadrosDaAnimacao[2][4]);
        andarPraCima.setPlayMode(PlayMode.LOOP_PINGPONG);
         andarPraEsquerda = new Animation(0.1f,
                quadrosDaAnimacao[3][0], // 1ª linha, 1ª coluna
                quadrosDaAnimacao[3][1], // idem, 2ª coluna
                quadrosDaAnimacao[3][2],
                quadrosDaAnimacao[3][3],
                quadrosDaAnimacao[3][4]);
        andarPraEsquerda.setPlayMode(PlayMode.LOOP_PINGPONG);
        atual = andarPraBaixo;
        tempoDaAnimacao = 0;
    }

    public void render(SpriteBatch batch) {
        //batch.draw(this.textura, this.posicaoX, this.posicaoY);
        batch.draw((TextureRegion) atual.getKeyFrame(tempoDaAnimacao), posicao.x, posicao.y);
    }

    public void update() {
        tempoDaAnimacao += Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            //goombaY += 10;
            atual = andarPraCima;
            if (posicao.y < Gdx.graphics.getHeight() - quadrosDaAnimacao[0][0].getRegionHeight()) {
                posicao.y++;
            }
        }else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            //goombaX -= 10;
            atual = andarPraEsquerda;
            if (posicao.x > 0) {
                posicao.x--;
            }
        }else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            //goombaY -= 10;
            atual = andarPraBaixo;
            if (posicao.y > 0) {
                posicao.y--;
            }
        }else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            //goombaX += 10;
            atual = andarPraDireita;
            if (posicao.x < Gdx.graphics.getWidth() - quadrosDaAnimacao[0][0].getRegionWidth()) {
                posicao.x++;
            }
        } else {
            tempoDaAnimacao = 0;
        }
    }
}
