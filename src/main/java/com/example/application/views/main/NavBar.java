package com.example.application.views.main;

import com.example.application.security.SecurityService;
import com.example.application.views.main.sections.PortfolioSection;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.stream.Stream;


public class NavBar extends Div {

    private final SecurityService securityService;
    private final Tabs tabs = new Tabs();
    private LoginView loginView;
    public NavBar(SecurityService securityService) {
        this.securityService = securityService;
        initialize();
    }

    public void initialize() {
        this.loginView = new LoginView();
        add(this.loginView);
        this.tabs.addClassName("content-tabs");
        setWidthFull();
        addClassNames("nav-bar");


        HorizontalLayout navBar = getNavBar();
        add(navBar);
    }

    private HorizontalLayout getNavBar() {
        H1 title = new H1("Jonathan Rowe");
        title.addClassNames(LumoUtility.Padding.Horizontal.MEDIUM, LumoUtility.FontSize.LARGE);
        Button loginButton = this.securityService.isUserLoggedIn() ?
                new Button("Logout", click -> this.securityService.logout()) :
                new Button("Login", click -> this.loginView.open());
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        loginButton.addClassNames(LumoUtility.Padding.Horizontal.MEDIUM, LumoUtility.FontSize.LARGE);
        HorizontalLayout navBar = new HorizontalLayout(FlexComponent.Alignment.CENTER, title, this.tabs, loginButton);
        navBar.addClassNames("content");
        return navBar;
    }

    public void addSections(PortfolioSection... sections) {
        Tab[] tabs = Stream.of(sections)
                .map(this::createTab)
                .toArray(Tab[]::new);

        this.tabs.add(tabs);
    }

    private Tab createTab(PortfolioSection target) {
        Tab tab = new Tab(target.getLabel());
        tab.getElement().addEventListener("click", e -> target.scrollIntoView());
        return tab;
    }

    public void setActiveTab(String label) {
        this.tabs.getChildren()
                .map(Tab.class::cast)
                .forEach(tab -> tab.setSelected(tab.getLabel().equals(label)));
    }

}
