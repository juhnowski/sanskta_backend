package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import static hello.ResponseParser.getSname;

/**
 *
 * @author ilya
 */
public class Handler {

    SortedSet<String> sl;
    SortedSet<String> searchList;

    SortedSet<Entry> ts;
    public SortedSet<Entry> entrySet;
    ObjectMapper mainMapper = new ObjectMapper();

    TransitionTable transitionTable = new TransitionTable();

    public Integer id = 0;
    
    public Handler() {

        this.sl = new TreeSet<>();
        searchList = Collections.synchronizedSortedSet(new TreeSet(sl));

        this.ts = new TreeSet<>();
        entrySet = Collections.synchronizedSortedSet(new TreeSet(ts));

    }


    public SortedSet<Entry> handle(String word) {
        doVariants("", word);

        searchList.forEach((w) -> {
            Entry e = checkWord(w);
            if (e != null) {
                entrySet.add(e);
            }
        }
        );
        return entrySet;
/*
        String result = "{}";
        try {
            result = mainMapper.writeValueAsString(entrySet);
            System.out.println("res=" + result);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return result;
        */
    }

    public static void main(String[] args) {
        String word = "Siva";

        Handler m = new Handler();

        m.doVariants("", word);

        m.searchList.forEach((w) -> {
            System.out.println("w:"+w);
            Entry e = m.checkWord(w);
            if (e != null) {
                m.entrySet.add(e);
            }
        }
        );
        
        try {
            System.out.println(m.mainMapper.writeValueAsString(m.entrySet));
            System.out.println("==================================");
            m.entrySet.forEach((Entry e) -> {
                System.out.println(e.word);
                System.out.println("+------>" + e.html);
            });

        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        System.out.println("-----------------");
        m.searchList.forEach((e) -> {
            System.out.println(e);
        });
    }

    public Entry checkWord(String word) {
        StringBuilder sb = new StringBuilder();
        sb.append("http://www.sanskrit-lexicon.uni-koeln.de/scans/WILScan/2014/web/webtc/getword.php?key=");
        sb.append(word);
        sb.append("&filter=roman&noLit=off&transLit=hk");
        String targetURL = sb.toString();
        String urlParameters = "";

        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/xhr");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            String s = response.toString();
            if (!s.contains("<h2>not found:")) {
                return new Entry(id++,getSname(s),word,word, s);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }


    
    public void doVariants(String prefix, String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(word);
        String prefWord = sb.toString();
        searchList.add(prefWord);
        System.out.println("+++ " + prefWord);
        transitionTable.forEach((SortedSet<String> seq) -> {
            seq.forEach((String ch) -> {
                if (word.startsWith(ch)) {
                    seq.forEach((String c) -> {
                       // if (!c.equals(ch)) {
                            String newWord = word.replaceFirst(ch, c);
                            String pref = prefix + c;
                            //if (newWord.length() > 0) {
                                String procWord = newWord.substring(c.length());
                               // if (procWord.length() > 0) {
                                    System.out.println("prefix=" + prefix + " word=" + word + " pref=" + pref + " procWord=" + procWord + " c=" + c + " ch=" + ch);
                                    doVariants(pref, procWord);
                                //}
                            //}
                        //}
                    });
                }
            });
        });
    }
}

/*
siva
sivA
siba
sibA
sIva
sIvA
sIba
sIbA
ziva
zivA
ziba
zibA
zIva
zIvA
zIba
zIbA
Siva
SivA
Siba
SibA
SIva
SIvA
SIba
SIbA
*/