package br.edu.ifrs.canoas.lds.fluentlenium.page;


import lombok.Data;
import org.fluentlenium.assertj.FluentLeniumAssertions;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@PageUrl("http://localhost:{port}/protot/pages/tables/data.html")
@Data
public class DatatablePage  extends FluentPage{

    @FindBy(css = "input.input-sm")
    private FluentWebElement search;

    @FindBy(css = "li.paginate_button")
    private FluentWebElement paginator;

    public void isAt() {
        assertThat(window().title()).isEqualTo("AdminLTE 2 | Data Tables");
        FluentLeniumAssertions.assertThat(el("td")).hasText("Gecko");
    }

}
