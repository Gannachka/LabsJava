package main.java;

public class Main {

    public enum Season {
        WINTER("Cold season"),
        SPRING("Cool season"),
        SUMMER("Hot season");

        private String description;

        private Season(String description) {
            this.description = description;
        }

        public String getDescription() {return description;}
    };


    public enum FiveMonths{
        Jan,
        Feb,
        Mar,
        Apr,
        May,
        June,
        July;
    }

    public static void main(String[] args) {
        String str1 = new String();
        System.out.println("str1.length() = " + str1.length());

        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7'};
        String str2=new String(chars);
        System.out.println("str2.length() = " +  str2.length()+ " str2 = " + str2);

        String str3 = new String( chars,3,5);
        System.out.println("str3.length() = " + str3.length()+" str3 "+str3);

        String str4 = "01234567";
        System.out.println("str4.length() = " + str4.length()+" str4 "+str4);

        String str5 = new String( "01234567");
        System.out.println("str5.length() = " + str5.length()+" str5 "+str5);

        System.out.println("\"01234567\".leng = " + "01234567".length());

        String str6 = new String("01234567");
        for (int i=0; i<str6.length(); i++){
            System.out.print(str6.charAt(i) + ((i< str1.length()-1)?"-":""));
        }

        System.out.println("");
        char[] chars1 = new char [6-2];
        str6.getChars(2,6,chars1,0);
        for (int i=0; i< chars1.length;i++) {
            System.out.print(chars1[i] + ((i < chars1.length - 1 ? "-" : "")));
        }

        String str7=new String("01234567");
        String str8=new String("01234567");
        System.out.println("(str7 == str8) = "+ (str7 == str8));
        System.out.println("(str7 == \"01234567\") = "+ (str7 == "01234567"));
        System.out.println("str7.equals(str8) = "+ str7.equals(str8));
        String str9 = str8 ;
        System.out.println("(str9 == str8) = "+ (str9 == str8));


        String str10 = new String("Человека невозможно чему-нибудь научить, его можно убедить");
        System.out.println(str10.indexOf('j'));
        System.out.println(str10.indexOf('о'));
        System.out.println(str10.lastIndexOf('o')) ;
        System.out.println(str10.indexOf('о',5));
        System.out.println(str10.lastIndexOf('о',5));
        System.out.println(str10.lastIndexOf('о',14));

        String str11 = new String("Лучший вид на этот город, если сесть в бомбардировщик");
        System.out.println(str11.substring(26));
        System.out.println(str11.substring(26,30));

        String str12 = new String("Оффтопик -- любое сетевое сообщение" +
                "выходящее за рамки ранее установленной темы");
        System.out.println(str12.replace('ф','f'));
        System.out.println(str12.toUpperCase());
        System.out.println(str12.toLowerCase());

        StringBuffer str15 = new StringBuffer();
        str15.append("В городе Сочи тёмные ночи");
        System.out.println("str15.length() = "+ str15.length());
        System.out.println("str15.capacity() = "+ str15.capacity());
        str15.insert(21, "и тёплые");
        System.out.println(str15);
        System.out.println("str15.length()"+str15.length());
        System.out.println("str15.capacity()"+str15.capacity());
        str15.delete(21,30);
        System.out.println(str15);
        str15.ensureCapacity(200);
        System.out.println("str15.capacity() = "+str15.capacity());
        String str16= str15.toString();

        FiveMonths month = FiveMonths.May;

        switch (month){
            case Apr:System.out.println("April");break;
            case May:System.out.println("May");break;
            case June:System.out.println("June");break;
            default: System.out.println("default");
        }
        for (Season s : Season.values())
            System.out.println(s + ": " + s.getDescription());
    }
}

