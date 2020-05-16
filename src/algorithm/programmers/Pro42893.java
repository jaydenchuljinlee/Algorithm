package algorithm.programmers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 2019 īī�� ����ε�
 * ��Ī ����
 *
 * */
public class Pro42893 {
    //���� ����Ʈ URL
    private Pattern CURRENT_URL  = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
    //�ܺ� ��ũ
    private Pattern EXTERNAL_URL = Pattern.compile("<a href=\"https://(.+?)\">");

    //���������� ������ ��� �ִ�. URL�� ������ ������ ã�´�.
    private HashMap<String, Page> pageUrl = new HashMap<>();

    //������ ����
    private class Page {
        String html;
        String word;
        String url;
        int defaultGrade;
        int idx;

        //�ش� url�� �̵��� �� �ִ� ��ũ
        HashSet<String> linkTo    = new HashSet<>();
        //�ش� url�� ���� �� �ִ� ��ũ
        HashSet<String> linkFrome = new HashSet<>();

        public Page(String html, String word, int idx) {
            this.html = html;
            this.word = word;
            this.idx  = idx;

            init();//�⺻ url������ �������ش�.
            calculateDefaultGrade();//�⺻ ������ �������ش�.
        }

        //�⺻ url����
        public void init() {

            Matcher matcher = CURRENT_URL.matcher(this.html);

            while(matcher.find()) this.url = matcher.group(1);
        }

        //�⺻ ���� ���ϱ�
        public void calculateDefaultGrade() {

            int find = this.html.indexOf(this.word);

            while(find != -1) {

                char prev = this.html.charAt(find-1);
                char next = this.html.charAt(find + this.word.length());

                //�ܾ��� ��/�ڷ� a~z�� ���ڰ� ���ԵǾ��ִ��� �˻�. �ܾ �ݺ��ǰų� �ٸ� ���ڸ� �����ϸ� �ȵǱ� ����
                if ((prev < 'a' || prev > 'z') && (next < 'a' || next > 'z')) this.defaultGrade++;

                //�ܾ �˻������Ƿ�, ���� �ܾ �˻��ϱ� ���� ���� �ε������� +1���� �ܾ �˻��Ѵ�.
                find = this.html.indexOf(this.word,find+1);

            }

        }

        //��ũ�� ����
        public void setLink() {

            Matcher matcher = EXTERNAL_URL.matcher(this.html);

            while(matcher.find()) {

                String link = matcher.group(1);//��ũ ����

                //���� �������� �ش� ��ũ ������ �ߺ����� �ʰ� �߰�
                if (!this.linkTo.contains(link)) this.linkTo.add(link);

                //�ش� ��ũ�� ������ ������ ���κ��� �Դ��� �߰�
                if (pageUrl.containsKey(link)) pageUrl.get(link).linkFrome.add(this.url);
            }
        }

        //��ü ����
        public double getTotalGrade() {

            double sum = this.defaultGrade;//�⺻ ������ ����

            for (String link : linkFrome) {//�ܺ� ������ ���ϱ� ���� ���κ��� �����Ǿ����� �˻�

                if (pageUrl.containsKey(link)) {//������ ������ �����ϴ� �ܺ� ��ũ���

                    Page page = pageUrl.get(link);

                    if (page.linkTo.size() > 0) {//�ش� �������� ��ũ ����� ���� ��ü ������ ���Ѵ�.

                        sum += (double) page.defaultGrade/page.linkTo.size();


                    }
                }
            }


            return sum;
        }
    }

    public int solution(String word, String[] pages) {

        int idx = 0;

        for (String html : pages) {

            //�⺻ ���� ����
            Page page = new Page(html.toLowerCase(),word.toLowerCase(),idx);

            //�⺻���� ���� ��, ������ ������ map�� ����
            pageUrl.put(page.url,page);

            idx++;
        }

        //����� ������ �������� ���� �ܺ� ��ũ�� �������ش�.
        for (Page page : pageUrl.values()) page.setLink();

        int answer = 0;

        double max = 0;

        //��ü ������ ���ϰ�, �ִ��� ���Ѵ�.
        for (Page page : pageUrl.values()) {

            double total = page.getTotalGrade();

            if (total > max) {

                max = total;
                answer = page.idx;
            }
        }

        return answer;
    }
}
