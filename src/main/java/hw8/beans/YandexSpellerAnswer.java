package hw8.beans;

import lombok.Getter;

import java.util.List;

@Getter
public class YandexSpellerAnswer {

        private Integer code;
        private Integer pos;
        private Integer row;
        private Integer col;
        private Integer len;
        private String word;
        private List<String> stag;
}