package br.edu.ifrs.canoas.lds.fluentlenium.page;


import lombok.Data;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@PageUrl("http://localhost:{port}/protot/index2.html")
@Data
public class HomePage  extends FluentPage{

    @FindBy(id = "link-tables")
    private FluentWebElement linkTable;

    @FindBy(id = "link-datatable")
    private FluentWebElement linkDatatable;

    public void isAt() {
        assertThat(window().title()).isEqualTo("AdminLTE 2 | Dashboard");
    }

}
