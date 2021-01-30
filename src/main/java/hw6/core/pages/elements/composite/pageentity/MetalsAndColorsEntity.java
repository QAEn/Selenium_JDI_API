package hw6.core.pages.elements.composite.pageentity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MetalsAndColorsEntity {

    private Integer summaryTop;
    private Integer summaryBottom;
    @JsonProperty("summary")
    private List<String> summary;

    @JsonProperty("elements")
    private List<String> elements;

    @JsonProperty("color")
    private String color;

    @JsonProperty("metals")
    private String metals;

    @JsonProperty("vegetables")
    private List<String> vegetables;

    public Integer getAmount() {
        return Integer.parseInt(summary.get(0))
             + Integer.parseInt(summary.get(1));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        MetalsAndColorsEntity metalsAndColorsEntity = (MetalsAndColorsEntity) object;

        return Objects.equals(elements, metalsAndColorsEntity.elements)
            && Objects.equals(color, metalsAndColorsEntity.color)
            && Objects.equals(metals, metalsAndColorsEntity.metals)
            && Objects.equals(vegetables, metalsAndColorsEntity.vegetables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements, color, metals, vegetables);
    }
}