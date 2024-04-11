package com.example.application.views.main;

import com.example.application.views.main.sections.PortfolioSection;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class ScrollableContent extends VerticalLayout {

    public ScrollableContent(PortfolioSection... children) {
        super(children);
        addScrollTracking(children);
    }

    @ClientCallable
    public void selectTab(int scrollTop, String[] sections, int[] offsets) {
        int activeIndex = 0;
        for (int i = 0; i < sections.length; i++) {
            if (scrollTop > offsets[activeIndex]) {
                activeIndex = i;
                System.out.println("Selected tab: " + sections[i]);
            }
        }
        String label = sections[activeIndex];
        getParent().ifPresent(parent->((MainView)parent).setActiveTab(label));
    }

    private void addScrollTracking(PortfolioSection... sections) {
        List<String> sectionsList = Arrays.stream(sections)
                .map(PortfolioSection::getLabel)
                .map(st->"'"+st+"'")
                .toList();
        List<String> selectorsList = sectionsList.stream()
                .map(String::toLowerCase)
                .map(sectionLabel->"Array.from(document.getElementsByClassName(["+ sectionLabel +"])).forEach(function(element) {offsets.push(element.offsetTop)})").toList();
        String js = """
                        function debounce(func, timeout = 300){
                            let timer;
                            return (...args) => {
                            clearTimeout(timer);
                            timer = setTimeout(() => { func.apply(this, args); }, timeout);
                            };
                        }
                        var el = this;
                        %s
                        el.addEventListener("scroll", debounce(function(e) {
                            if(el.$server) {
                                el.$server.selectTab(el.offsetTop + el.scrollTop, [%s], getOffsets());
                            }
                        }));
                    """;
        getElement().executeJs(String.format(js,
                "function getOffsets(){ var offsets = []; " +
                        StringUtils.join(selectorsList, ";") +
                        ";return offsets;}",
                StringUtils.join(sectionsList, ",")

        ));
    }
}
