class Solution {
public:
    bool isValid(string s) {

        stack<char> openingBrackets;

        for(int i = 0; i < s.length(); i++) {

            if(s[i] == '(' || s[i] == '[' || s[i] == '{') {
                openingBrackets.push(s[i]);
            }

            else if(s[i] == ')' &&
                    !openingBrackets.empty() &&
                    openingBrackets.top() == '(') {

                openingBrackets.pop();
            }

            else if(s[i] == ']' &&
                    !openingBrackets.empty() &&
                    openingBrackets.top() == '[') {

                openingBrackets.pop();
            }

            else if(s[i] == '}' &&
                    !openingBrackets.empty() &&
                    openingBrackets.top() == '{') {

                openingBrackets.pop();
            }

            else {
                return false;
            }
        }

        return openingBrackets.empty();
    }
};