package leetcode.contests;

import java.util.HashSet;
import java.util.Set;

public class NumberOfUniqueEmails {
    public static void main(String[] args) {
        String[] emails = new String[]{"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        NumberOfUniqueEmails e = new NumberOfUniqueEmails();
        System.out.println(e.numUniqueEmails(emails));

    }

    public int numUniqueEmails(String[] emails) {
        if(emails==null || emails.length==0)
            return 0;

        // seperate the @ emails

        Set<String> set=new HashSet<String>();
        StringBuilder sb=new StringBuilder();
        for (String s : emails) {
            String[] clearInputs= s.split("@");
            String local=clearInputs[0];
            String domain=clearInputs[1];

            int i=0;
            while (local.charAt(i)!='+'){
                if(local.charAt(i)!='.'){
                    sb.append(local.charAt(i));
                }
                i++;
            }
            System.out.println(sb);
            sb.append(domain);
            set.add(sb.toString());
            sb.setLength(0);
        }

        return set.size();

    }
}
