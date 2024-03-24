package com.example.application.views.main.sections;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class Projects extends PortfolioSection {
    public Projects() {
        super("Projects");
        HorizontalLayout flexContainer = new HorizontalLayout();
        flexContainer.addClassName("flex-container");
        addClassName("projects");
        Div div = new Div();
        div.addClassNames("block");
        Div div2 = new Div();
        div2.addClassNames("block");
        Div div3 = new Div();
        div3.addClassNames("block");
        Div div4 = new Div();
        div4.addClassNames("block");
        flexContainer.add(div, div2, div3, div4);
        add(flexContainer);
    }
}
