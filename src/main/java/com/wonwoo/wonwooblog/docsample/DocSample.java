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

    @GetMapping(value="/index")
    public String showIndex() {
        return "index";
    }

    @GetMapping(value="/index2")
    public String showIndex2() {
        return "index2";
    }

    @GetMapping(value="/top_nav")
    public String showTopNav() {
        return "pages/layoutview/top-nav";
    }

    @GetMapping(value="/boxed")
    public String showBoxed() {
        return "pages/layoutview/boxed";
    }

    @GetMapping(value="/fixed")
    public String showFixed() {
        return "pages/layoutview/fixed";
    }

    @GetMapping(value="/collapsed_sidebar")
    public String showCollapsedSidebar() {
        return "pages/layoutview/collapsed-sidebar";
    }

    @GetMapping(value="/widgets")
    public String showWidgets() {
        return "pages/widgets";
    }

    @GetMapping(value="/chartjs")
    public String showChartjs() {
        return "pages/charts/chartjs";
    }

    @GetMapping(value="/flot")
    public String showFlot() {
        return "pages/charts/flot";
    }

    @GetMapping(value="/morris")
    public String showMorris() {
        return "pages/charts/morris";
    }

    @GetMapping(value="/inline")
    public String showInline() {
        return "pages/charts/inline";
    }

    @GetMapping(value="/general")
    public String showGeneral() {
        return "pages/UI/general";
    }

    @GetMapping(value="/icons")
    public String showIcons() {
        return "pages/UI/icons";
    }

    @GetMapping(value="/buttons")
    public String showButtons() {
        return "pages/UI/buttons";
    }

    @GetMapping(value="/sliders")
    public String showSliders() {
        return "pages/UI/sliders";
    }

    @GetMapping(value="/timeline")
    public String showTimeline() {
        return "pages/UI/timeline";
    }

    @GetMapping(value="/modals")
    public String showModals() {
        return "pages/UI/modals";
    }

    @GetMapping(value="/forms_general")
    public String showFormsGeneral() {
        return "pages/forms/general";
    }

    @GetMapping(value="/advanced")
    public String showAdvanced() {
        return "pages/forms/advanced";
    }

    @GetMapping(value="/editors")
    public String showEditors() {
        return "pages/forms/editors";
    }

    @GetMapping(value="/tables_simple")
    public String showTablesSimple() {
        return "pages/tables/simple";
    }

    @GetMapping(value="/tables_data")
    public String showTablesData() {
        return "pages/tables/data";
    }

    @GetMapping(value="/calendar")
    public String showCalendar() {
        return "pages/calendar";
    }

    @GetMapping(value="/mailbox")
    public String showMailbox() {
        return "pages/mailbox/mailbox";
    }

    @GetMapping(value="/compose")
    public String showCompose() {
        return "pages/mailbox/compose";
    }

    @GetMapping(value="/read_mail")
    public String showReadMail() {
        return "pages/mailbox/read-mail";
    }

    @GetMapping(value="/examples_invoice")
    public String showExamplesInvoice() {
        return "pages/examples/invoice";
    }

    @GetMapping(value="/example_invoice_print")
    public String showExamplesInvoicePrint() {
        return "pages/examples/invoice-print";
    }

    @GetMapping(value="/examples_profile")
    public String showExamplesProfile() {
        return "pages/examples/profile";
    }

    @GetMapping(value="/examples_login")
    public String showExamplesLogin() {
        return "pages/examples/login";
    }

    @GetMapping(value="/examples_register")
    public String showExamplesRegister() {
        return "pages/examples/register";
    }

    @GetMapping(value="/examples_lockscreen")
    public String showExamplesLockscreen() {
        return "pages/examples/lockscreen";
    }

    @GetMapping(value="/examples_404")
    public String showExamples404() {
        return "pages/examples/404";
    }

    @GetMapping(value="/examples_500")
    public String showExamples500() {
        return "pages/examples/500";
    }

    @GetMapping(value="/examples_blank")
    public String showExamplesBlank() {
        return "pages/examples/blank";
    }

    @GetMapping(value="/examples_pace")
    public String showExamplesPace() {
        return "pages/examples/pace";
    }
}