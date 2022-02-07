
package javaard_web;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javafx.util.Pair;

public class JavaARD_WEB {

// первый аргумент - имя файла, содержащего HTTP запрос
    // предполагается, что запрос не будет больше 64 килобайт
    // второй - имя файла, куда будет слит ответ сервера
public static void main(String args[])
{

}

private static void process(String domainStr,
                            String dateStr,
                            String numberStr) throws IOException {
  String s = getUrl("http://www.liveinternet.ru/stat/" + domainStr +
                    "/pages.html?date=" + dateStr +
                    "&period=month&total=yes&per_page=100");
  ArrayList< Pair<String, Integer> > pages =
    parseLiveinternatStat(domainStr, s);
  int maxNumber = Integer.parseInt(numberStr);
  int currentNumber = 0;
  System.out.println("<ul>");
  for(Pair<String, Integer> p : pages) {
    String url = p.getLeft();
    int views = p.getRight();
    String title = getPageTitle(url);
    String end = ending(views);
    System.out.printf("<li><a href=\"%s\">%s</a> %d просмотр%s " +
                      "за месяц</a></li>\n", url, title, views, end);
    currentNumber++;
    if(currentNumber >= maxNumber) break;
  }
  System.out.println("</ul>");
}

//==============================================================================    
    }
    
