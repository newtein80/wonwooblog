package com.wonwoo.wonwooblog.docsample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * DocSample
 */
@Controller
@RequestMapping("/sample")
public class DocSample {

    private final String sampleRootPath = "pages/sample/";

    @GetMapping(value="/index")
    public String showIndex() {
        return sampleRootPath + "index";
    }

    @GetMapping(value="/index2")
    public String showIndex2() {
        return sampleRootPath + "index2";
    }

    @GetMapping(value="/top_nav")
    public String showTopNav() {
        return sampleRootPath + "layoutview/top-nav";
    }

    @GetMapping(value="/boxed")
    public String showBoxed() {
        return sampleRootPath + "layoutview/boxed";
    }

    @GetMapping(value="/fixed")
    public String showFixed() {
        return sampleRootPath + "layoutview/fixed";
    }

    @GetMapping(value="/collapsed_sidebar")
    public String showCollapsedSidebar() {
        return sampleRootPath + "layoutview/collapsed-sidebar";
    }

    @GetMapping(value="/widgets")
    public String showWidgets() {
        return sampleRootPath + "widgets";
    }

    @GetMapping(value="/chartjs")
    public String showChartjs() {
        return sampleRootPath + "charts/chartjs";
    }

    @GetMapping(value="/flot")
    public String showFlot() {
        return sampleRootPath + "charts/flot";
    }

    @GetMapping(value="/morris")
    public String showMorris() {
        return sampleRootPath + "charts/morris";
    }

    @GetMapping(value="/inline")
    public String showInline() {
        return sampleRootPath + "charts/inline";
    }

    @GetMapping(value="/general")
    public String showGeneral() {
        return sampleRootPath + "UI/general";
    }

    @GetMapping(value="/icons")
    public String showIcons() {
        return sampleRootPath + "UI/icons";
    }

    @GetMapping(value="/buttons")
    public String showButtons() {
        return sampleRootPath + "UI/buttons";
    }

    @GetMapping(value="/sliders")
    public String showSliders() {
        return sampleRootPath + "UI/sliders";
    }

    @GetMapping(value="/timeline")
    public String showTimeline() {
        return sampleRootPath + "UI/timeline";
    }

    @GetMapping(value="/modals")
    public String showModals() {
        return sampleRootPath + "UI/modals";
    }

    @GetMapping(value="/forms_general")
    public String showFormsGeneral() {
        return sampleRootPath + "forms/general";
    }

    @GetMapping(value="/advanced")
    public String showAdvanced() {
        return sampleRootPath + "forms/advanced";
    }

    @GetMapping(value="/editors")
    public String showEditors() {
        return sampleRootPath + "forms/editors";
    }

    @GetMapping(value="/tables_simple")
    public String showTablesSimple() {
        return sampleRootPath + "tables/simple";
    }

    @GetMapping(value="/tables_data")
    public String showTablesData() {
        return sampleRootPath + "tables/data";
    }

    @GetMapping(value="/calendar")
    public String showCalendar() {
        return sampleRootPath + "calendar";
    }

    @GetMapping(value="/mailbox")
    public String showMailbox() {
        return sampleRootPath + "mailbox/mailbox";
    }

    @GetMapping(value="/compose")
    public String showCompose() {
        return sampleRootPath + "mailbox/compose";
    }

    @GetMapping(value="/read_mail")
    public String showReadMail() {
        return sampleRootPath + "mailbox/read-mail";
    }

    @GetMapping(value="/examples_invoice")
    public String showExamplesInvoice() {
        return sampleRootPath + "examples/invoice";
    }

    @GetMapping(value="/example_invoice_print")
    public String showExamplesInvoicePrint() {
        return sampleRootPath + "examples/invoice-print";
    }

    @GetMapping(value="/examples_profile")
    public String showExamplesProfile() {
        return sampleRootPath + "examples/profile";
    }

    @GetMapping(value="/examples_login")
    public String showExamplesLogin() {
        return sampleRootPath + "examples/login";
    }

    @GetMapping(value="/examples_register")
    public String showExamplesRegister() {
        return sampleRootPath + "examples/register";
    }

    @GetMapping(value="/examples_lockscreen")
    public String showExamplesLockscreen() {
        return sampleRootPath + "examples/lockscreen";
    }

    @GetMapping(value="/examples_404")
    public String showExamples404() {
        return sampleRootPath + "examples/404";
    }

    @GetMapping(value="/examples_500")
    public String showExamples500() {
        return sampleRootPath + "examples/500";
    }

    @GetMapping(value="/examples_blank")
    public String showExamplesBlank() {
        return sampleRootPath + "examples/blank";
    }

    @GetMapping(value="/examples_pace")
    public String showExamplesPace() {
        return sampleRootPath + "examples/pace";
    }
}