/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

/**
 *
 * @author ilya
 */
public class ResponseParser {

    static String test = "{\"word\":\"Siva\",\"html\":\"<META HTTP-EQUIV=\\\"Content-Type\\\" CONTENT=\\\"text/html; charset=utf-8\\\">\\r<!--filter=roman<br>,filterin=hk-->\\r<h1>&nbsp;б№Јiva</h1>\\r<table class='display'>\\r<tr><td class='display' valign=\\\"top\\\"><span class='lnum'> [L=39546]</span><span class='hrefdata'> [p= <a href='../webtc/servepdf.php?page=871' target='_Blank'>871</a>]</span></td>\\r<td class='display' valign=\\\"top\\\">.<span class='sdata'>б№Јiva</span>В¦ (<span class='sdata'>u</span>) <span class='sdata'>б№Јivu</span> r. 4th cl. (<span class='sdata'>sД«vyati</span>)<br/>1 To sew, to stitch.<br/>3 To sow, as seed.</td></tr>\\r</table>\\r\"},";

    public static String getSname(String s) {
        String[] sarr = s.split("h1");
        String result = sarr[1];
        result = result.replace(">&nbsp;", "").replace("</", "");
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(getSname(test));
    }

}
