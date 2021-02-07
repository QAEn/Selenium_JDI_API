package hw8.steps.assertionlayer;

import java.util.List;

import lombok.AllArgsConstructor;

import hw8.beans.YandexSpellerAnswer;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
public class CheckerOfAnswers {

    private List<YandexSpellerAnswer> answers;

    public CheckerOfAnswers checkThatBodyHasErrorCode(int code) {
        assertThat(answers.get(0)).extracting("code").isSameAs(code);
        return this;
    }

    public CheckerOfAnswers checkThatBodyHasErrorPos(int pos) {
        assertThat(answers.get(0)).extracting("pos").isSameAs(pos);
        return this;
    }

    public CheckerOfAnswers checkThatBodyHasErrorRow(int row) {
        assertThat(answers.get(0)).extracting("row").isSameAs(row);
        return this;
    }

    public CheckerOfAnswers checkThatBodyHasErrorCol(int col) {
        assertThat(answers.get(0)).extracting("col").isSameAs(col);
        return this;
    }

    public CheckerOfAnswers checkThatBodyHasErrorLen(Integer len) {
        assertThat(answers.get(0)).extracting("len").isSameAs(len);
        return this;
    }

    public CheckerOfAnswers checkThatWordWithErrorExistsAtAnswer(String errorWord) {
        assertThat(answers).extracting(YandexSpellerAnswer::getWord).contains(errorWord);
        return this;
    }
}