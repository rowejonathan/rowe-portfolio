package com.example.application.views.main.sections;

import com.vaadin.flow.component.html.Div;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class PortfolioSection extends Div {
    private String label;
}
