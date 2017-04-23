package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
        id: 6,
        sname: 'अनभिहितवाच्य',
        ename: 'omission'
 */
public class Entry implements Comparable{
        public Integer id;
        public String sname;
        public String ename;
        
        public String word;
        public String html;

        public Integer getId(){
            return id;
        }

        public String getSname(){
            return sname;
        }
        
        public String getEname(){
            return word;
        }
        
        public String getWord(){
            return word;
        }
        
        public String getHtml(){
            return html;
        }
        
        public Entry(Integer id, String sname, String ename, String word, String html) {
            this.id = id;
            this.sname = sname;
            this.ename = ename;
            this.word = word;
            this.html = html;
        }

        @Override
        public String toString() {
            ObjectMapper mapper = new ObjectMapper();
            String s = "";
            try {
                s = mapper.writeValueAsString(this);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return s;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }

            Entry e = (Entry) o;

            return this.word.equals(e.word);
        }

        @Override
        public int hashCode() {
            return word.hashCode();
        }

        @Override
        public int compareTo(Object t) {
            if (!(t instanceof Entry)) {
                return 0;
            }

            Entry e = (Entry) t;
            return this.word.compareTo(e.word);
        }
}
