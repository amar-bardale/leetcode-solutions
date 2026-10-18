class Solution {
    public String generateTag(String caption) {

        boolean capitalize = false;

        StringBuilder sb = new StringBuilder(100);
        sb.append("#");

        for (int i = 0; i < caption.length(); i++) {

            char ch = caption.charAt(i);

            if (ch == ' ') {
                capitalize = sb.length() > 1;
                continue;
            }

            if (ch >= 'A' && ch <= 'Z') {
                ch += 32;
            }

            if (capitalize) {
                ch -= 32;
                capitalize = false;
            }

            sb.append(ch);

            if (sb.length() == 100) {
                break;
            }
        }

        return sb.toString();
    }
}