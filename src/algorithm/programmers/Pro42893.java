package algorithm.programmers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 2019 카카오 블라인드
 * 매칭 점수
 *
 * */
public class Pro42893 {
    //현재 사이트 URL
    private Pattern CURRENT_URL  = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
    //외부 링크
    private Pattern EXTERNAL_URL = Pattern.compile("<a href=\"https://(.+?)\">");

    //페이지들의 정보를 담고 있다. URL로 페이지 정보를 찾는다.
    private HashMap<String, Page> pageUrl = new HashMap<>();

    //페이지 정보
    private class Page {
        String html;
        String word;
        String url;
        int defaultGrade;
        int idx;

        //해당 url이 이동할 수 있는 링크
        HashSet<String> linkTo    = new HashSet<>();
        //해당 url로 들어올 수 있는 링크
        HashSet<String> linkFrome = new HashSet<>();

        public Page(String html, String word, int idx) {
            this.html = html;
            this.word = word;
            this.idx  = idx;

            init();//기본 url정보를 셋팅해준다.
            calculateDefaultGrade();//기본 점수를 셋팅해준다.
        }

        //기본 url정보
        public void init() {

            Matcher matcher = CURRENT_URL.matcher(this.html);

            while(matcher.find()) this.url = matcher.group(1);
        }

        //기본 점수 구하기
        public void calculateDefaultGrade() {

            int find = this.html.indexOf(this.word);

            while(find != -1) {

                char prev = this.html.charAt(find-1);
                char next = this.html.charAt(find + this.word.length());

                //단어의 앞/뒤로 a~z의 문자가 포함되어있는지 검사. 단어가 반복되거나 다른 문자를 포함하면 안되기 때문
                if ((prev < 'a' || prev > 'z') && (next < 'a' || next > 'z')) this.defaultGrade++;

                //단어를 검사했으므로, 다음 단어를 검사하기 위해 현재 인덱스에서 +1부터 단어를 검색한다.
                find = this.html.indexOf(this.word,find+1);

            }

        }

        //링크를 셋팅
        public void setLink() {

            Matcher matcher = EXTERNAL_URL.matcher(this.html);

            while(matcher.find()) {

                String link = matcher.group(1);//링크 정보

                //현재 페이지에 해당 링크 정보를 중복되지 않게 추가
                if (!this.linkTo.contains(link)) this.linkTo.add(link);

                //해당 링크의 페이지 정보에 어디로부터 왔는지 추가
                if (pageUrl.containsKey(link)) pageUrl.get(link).linkFrome.add(this.url);
            }
        }

        //전체 점수
        public double getTotalGrade() {

            double sum = this.defaultGrade;//기본 점수로 셋팅

            for (String link : linkFrome) {//외부 점수를 구하기 위해 어디로부터 참조되었는지 검사

                if (pageUrl.containsKey(link)) {//페이지 정보에 존재하는 외부 링크라면

                    Page page = pageUrl.get(link);

                    if (page.linkTo.size() > 0) {//해당 페이지의 링크 사이즈를 통해 전체 점수를 구한다.

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

            //기본 정보 셋팅
            Page page = new Page(html.toLowerCase(),word.toLowerCase(),idx);

            //기본정보 셋팅 후, 페이지 정보를 map에 저장
            pageUrl.put(page.url,page);

            idx++;
        }

        //저장된 페이지 정보들을 통해 외부 링크를 셋팅해준다.
        for (Page page : pageUrl.values()) page.setLink();

        int answer = 0;

        double max = 0;

        //전체 점수를 구하고, 최댓값을 구한다.
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
