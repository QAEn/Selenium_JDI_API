package hw6.core.pages;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public enum Pages {
    METALS_COLORS("Metals & Colors");

    private String pageName;

    @Override
    public String toString() {
        return pageName;
    }
}