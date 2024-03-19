package com.example.application.views.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Main")
@Route(value = "")
public class MainView extends VerticalLayout {
    Introduction introduction = new Introduction();
    Projects projects = new Projects();
    Experience experience = new Experience();
    Contact contact = new Contact();
    public MainView() {
        addClassNames("main-view", LumoUtility.Overflow.HIDDEN);
        H1 title = new H1("Jonathan Rowe");
        title.addClassNames(LumoUtility.Margin.Start.MEDIUM, LumoUtility.FontSize.LARGE);
        HorizontalLayout navBar = new HorizontalLayout(Alignment.CENTER, title, createTabs());
        navBar.addClassNames("nav-bar", LumoUtility.Background.PRIMARY, LumoUtility.Width.FULL, LumoUtility.BoxShadow.MEDIUM, LumoUtility.TextColor.PRIMARY_CONTRAST);
        VerticalLayout scrollableContent = new VerticalLayout(introduction, projects, experience, contact);
        scrollableContent.addClassNames("hidden-scroller", LumoUtility.Overflow.SCROLL);
        add(navBar, scrollableContent);
    }

    private Tabs createTabs() {
        Tabs tabs = new Tabs(
                createTab("Introduction", introduction),
                createTab("Projects", projects),
                createTab("Experience", experience),
                createTab("Contact", contact));
        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        return tabs;
    }

    private Tab createTab(String label, Component target) {
        Tab tab = new Tab(label);
        tab.getElement().addEventListener("click", e -> {
            target.scrollIntoView();
        });
        return tab;
    }

}
