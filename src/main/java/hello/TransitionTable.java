package hello;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author ilya
 */
public class TransitionTable extends ArrayList<SortedSet<String>> {

    public TransitionTable() {

        Comparator desc;
        desc = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                Integer i1 = s1.length();
                Integer i2 = s2.length();
                return i2.compareTo(i1);
            }
        };
        
        SortedSet<String> a = new TreeSet();
        a.add("a");
        a.add("A");

        this.add(a);

        SortedSet<String> i = new TreeSet();
        i.add("i");
        i.add("I");
        this.add(i);

        SortedSet<String> u = new TreeSet();
        u.add("u");
        u.add("U");
        this.add(u);

        
        
        SortedSet<String> r = new TreeSet<String>(desc);
        r.add("r");
        r.add("R");
        r.add("RR");
        this.add(r);

        SortedSet<String> l = new TreeSet<String>(desc);
        l.add("l");
        l.add("lR");
        l.add("lRR");
        this.add(l);

        SortedSet<String> h = new TreeSet<String>();
        h.add("h");
        h.add("H");
        this.add(h);

        SortedSet<String> m = new TreeSet<String>();
        m.add("M");
        m.add("n");
        m.add("N");
        m.add("J");
        m.add("G");
        this.add(m);

        SortedSet<String> z = new TreeSet<String>();
        z.add("z");
        z.add("S");
        z.add("s");
        this.add(z);

        SortedSet<String> b = new TreeSet<String>();
        b.add("b");
        b.add("v");
        this.add(b);

        SortedSet<String> k = new TreeSet<String>(desc);
        k.add("k");
        k.add("kh");
        this.add(k);

        SortedSet<String> g = new TreeSet<String>(desc);
        g.add("g");
        g.add("gh");
        this.add(g);

        SortedSet<String> c = new TreeSet<String>(desc);
        c.add("c");
        c.add("ch");
        this.add(c);

        SortedSet<String> j = new TreeSet<String>(desc);
        j.add("j");
        j.add("jh");
        this.add(j);

        SortedSet<String> t = new TreeSet<String>(desc);
        t.add("T");
        t.add("Th");
        t.add("t");
        t.add("th");
        this.add(t);

        SortedSet<String> d = new TreeSet<String>(desc);
        d.add("D");
        d.add("Dh");
        d.add("d");
        d.add("dh");
        this.add(d);

        SortedSet<String> p = new TreeSet<String>(desc);
        p.add("p");
        p.add("ph");
        this.add(p);

        SortedSet<String> b1 = new TreeSet<String>(desc);
        b1.add("b");
        b1.add("bh");
        this.add(b1);

        SortedSet<String> s1 = new TreeSet<String>(desc);
        s1.add("sh");
        s1.add("z");
        this.add(s1);
    }
}
