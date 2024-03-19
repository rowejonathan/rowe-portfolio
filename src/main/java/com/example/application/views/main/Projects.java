package com.example.application.views.main;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Projects extends HorizontalLayout {
    public Projects() {
        addClassName("projects");
        Div div = new Div();
        div.addClassNames("block");
        Div div2 = new Div();
        div2.addClassNames("block");
        Div div3 = new Div();
        div3.addClassNames("block");
        Div div4 = new Div();
        div4.addClassNames("block");
        add(div, div2, div3, div4);
    }
}
