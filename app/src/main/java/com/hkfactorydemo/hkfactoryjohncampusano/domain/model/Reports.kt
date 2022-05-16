package com.hkfactorydemo.hkfactoryjohncampusano.domain.model

import com.hkfactorydemo.hkfactoryjohncampusano.data.database.entities.PurchaseEntity

class Reports {
    private val HTMLCode =
        StringBuilder().append(
            "<html><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><head>" +
                    "<style type=\"text/css\">" +
                    ".no-margin-bottom{margin-bottom: 0px; width: 100%; border-spacing: 0;border-collapse: collapse;}" +
                    ".big{font-size: 12px}" +
                    "html, body, div, span, applet, object, iframe,\n" +
                    "h1, h2, h3, h4, h5, h6, p, blockquote, pre,\n" +
                    "a, abbr, acronym, address, big, cite, code,\n" +
                    "del, dfn, em, img, ins, kbd, q, s, samp,\n" +
                    "small, strike, strong, sub, sup, tt, var,\n" +
                    "b, u, i, center,\n" +
                    "dl, dt, dd, ol, ul, li,\n" +
                    "fieldset, form, label, legend,\n" +
                    "table, caption, tbody, tfoot, thead, tr, th, td,\n" +
                    "article, aside, canvas, details, embed, \n" +
                    "figure, figcaption, footer, header, hgroup, \n" +
                    "menu, nav, output, ruby, section, summary,\n" +
                    "time, mark, audio, video {\n" +
                    "    margin: 0;\n" +
                    "    padding: 0;\n" +
                    "    border: 0;\n" +
                    "    font-size: 100%;\n" +
                    "    font: inherit;\n" +
                    "    vertical-align: baseline;\n" +
                    "}\n" +
                    "/* HTML5 display-role reset for older browsers */\n" +
                    "article, aside, details, figcaption, figure, \n" +
                    "footer, header, hgroup, menu, nav, section {\n" +
                    "    display: block;\n" +
                    "}\n" +
                    "body {\n" +
                    "    line-height: 1;\n" +
                    "}\n" +
                    "ol, ul {\n" +
                    "    list-style: none;\n" +
                    "}\n" +
                    "blockquote, q {\n" +
                    "    quotes: none;\n" +
                    "}\n" +
                    "blockquote:before, blockquote:after,\n" +
                    "q:before, q:after {\n" +
                    "    content: '';\n" +
                    "    content: none;\n" +
                    "}\n" +
                    "table {\n" +
                    "    border-collapse: collapse;\n" +
                    "    border-spacing: 0;\n" +
                    "}" +
                    ".medium{font-size:10px;font-weight:400;}" +
                    ".medium-detail{font-size:10px;}" +
                    "table, th, td {padding-top: 0px; padding-bottom: 0px;}" +
                    ".table-borderless tbody+tbody,.table-borderless td,.table-borderless th,.table-borderless thead th{border:0}" +
                    ".ps{margin-bottom:0;margin-top:0;white-space: normal!important;}" +
                    ".divs{margin-bottom:0;margin-top:0;}" +
                    ".imgs{margin-bottom:0;margin-top:0;}" +
                    ".float-left{float:left!important}.float-right{float:right!important}.float-none{float:none!important}" +
                    ".text-right{text-align:right!important}" +
                    ".text-center{text-align:center!important}" +
                    ".w-100{width:100%!important}" +
                    "mt-2,.my-2{margin-top:.5rem!important}" +
                    ".table-sm td, .table-sm th {\n" +
                    "        padding: .15rem .3rem;\n" +
                    "      }\n" +
                    "      hr {\n" +
                    "        border-width: 2px;\n" +
                    "      }" +
                    ".font-weight-bold{font-weight:700!important}" +
                    ".small{font-size:6px;font-weight:400}" +
                    ".mb-2,.my-2{margin-bottom:.5rem!important}" +
                    ".px-1{padding-right:.25rem!important}" +
                    ".pb-1,.py-1{padding-bottom:.25rem!important}.pl-1,.px-1{padding-left:.25rem!important}" +
                    ".p-2{padding:.5rem!important}.pt-2,.py-2{padding-top:.5rem!important}" +
                    ".pr-2,.px-2{padding-right:.5rem!important}.pb-2,.py-2{padding-bottom:.5rem!important}" +
                    ".pl-2,.px-2{padding-left:.5rem!important}.p-3{padding:1rem!important}" +
                    ".pt-3,.py-3{padding-top:1rem!important}.pr-3,.px-3{padding-right:1rem!important}" +
                    ".pb-3,.py-3{padding-bottom:1rem!important}" +
                    "border-dark{border-color:#343a40!important}" +
                    ".mt-0,.my-0{margin-top:0!important}" +
                    ".pt-3,.py-3{padding-top:1rem!important}" +
                    ".mr-1,.mx-1{margin-right:.25rem!important}" +
                    ".mb-3,.my-3{margin-bottom:1rem!important}" +
                    "@media (min-width: 200px){.big{font-size: 18px;} .medium{font-size: 12px;} .small{font-size: 10px;}}" +
                    ".float-none{float:none!important}@media (min-width:576px){.float-sm-left{float:left!important}" +
                    ".tg {border:none;border-collapse:collapse;border-spacing:0;font-size:10px;width: 100%;}" +
                    ".tg td{border-style:solid;border-width:0px;overflow:hidden;padding:0px;word-break:normal;font-size:10px;}" +
                    ".tg th{border-style:solid;border-width:0px;font-weight:normal;overflow:hidden;padding:0px;word-break:normal;font-size:10px;}" +
                    ".tg .tg-baqh{text-align:center;vertical-align:top;font-size:10px;}" +
                    ".tg .tg-lqy6{text-align:right;vertical-align:top;font-size:10px;}" +
                    ".tg .tg-0lax{text-align:left;vertical-align:top; padding-right: 10px;font-size:10px;}" +
                    ".hrs {width:100%;height:2px;color:black;background-color:black;text-align:left;}" +
                    ".px-2{padding-right:.5rem!important}.pb-2,.py-2{padding-bottom:.5rem!important}" +
                    ".right-text{text-align: right;}" +
                    ".pt-4,.py-4{padding-top:1.5rem!important}.pr-4,.px-4{padding-right:1.5rem!important}.pb-4,.py-4{padding-bottom:1.5rem!important}.pl-4,.px-4{padding-left:1.5rem!important}}" +
                    "</style>" +
                    "</head><body>"
        )

        fun document(purchase: PurchaseEntity, details: List<Details>){

            setTitle(purchase)
            setDetails(details)
            total(purchase)

        }

    private fun addCommandHTML(string: String) {
        HTMLCode.append(string)
    }


    private fun addLineSeparator() {
        addCommandHTML("<hr class=\"border-dark mt-0 mb-2\">")
    }

    private fun setTitle(purchase: PurchaseEntity) {
        addCommandHTML(
            "<table class=\"w-100 big\">" +
                    "<tr>\n" +
                    "              <td>\n" +
                    "                <span><strong>${purchase.seller}</strong></span>\n" +
                    "              </td>\n" +

                    "              <td class=\"text-right\">\n" +
                    "                <span>${purchase.ncf}</span>\n" +
                    "              </td>" +
                    "            </tr>\n" +
                    "</table>"
        )

        addCommandHTML(
            "<table class=\"w-100 big\">" +
                    "<tr>\n" +
                    "              <td>\n" +
                    "                <span><strong>${purchase.customerName}</strong></span>\n" +
                    "              </td>\n" +

                    "              <td class=\"text-right\">\n" +
                    "                <span>${purchase.vatId}</span>\n" +
                    "              </td>" +
                    "            </tr>\n" +
                    "</table>"
        )
        addCommandHTML("<div class=\"text-center\"><span class=\"font-weight-bold medium\">RECIBO DE VENTA</span></div>")
    }

    private fun setDetails(details: List<Details>){
        addCommandHTML("<table class=\" mb-2 w-100 medium\"><tbody>")

        details.forEach {
            addCommandHTML(
                "<tr>\n" +
                        "              <td>\n" +
                        "                <span class=\"font-weight-bold\">Codigo:</span>" +
                        "                <span>${it.productCode}</span>\n" +
                        "                <span>${it.productQuantity} x ${it.productPrice}</span>\n" +
                        "              </td>\n" +
                                    "<td>\n" +
                         "                <span>${it.productName}</span>\n" +
                    "              </td>\n" +
                                         "<td>\n" +
                        "                <span>${it.subtotal}</span>\n" +
                        "              </td>\n" +
                        "            </tr></tbody></table>"
            )
        }
        addLineSeparator()
    }

    private fun total(purchase: PurchaseEntity){
        addCommandHTML(
            "<table class=\"w-100 medium\">" +
                    "<tr>" +
                    "<td>" +
                    "<span>Total:</span>" +
                    "</td>" +
                    "<td class=\"text-right\">" +
                    "<span>${purchase.totalSold}</span>" +
                    "</td>" +
                    "</tr></table>"
        )
    }
}