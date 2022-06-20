public class Operators
{
  //  public int []numbers;
  public String _operators = new String();
  public int []_masNum = new int[3];
  public boolean _incorrect = false;


    //////////////////////////////////
    public void findNumber(String s)
    {
        String str = "";
        int index = 0;
        boolean _minus = false;

        for(int i = 0; i <= s.length(); i++) {

            if (i < s.length() && Character.isDigit(s.charAt(i)))
                str += s.charAt(i);
            else {

                if (i < s.length())
                {
                    if (isOperator(s.charAt(i)))
                    {
                        if ((s.charAt(i) == '-' && i == 0) || (isOperator(s.charAt(i - 1)) && s.charAt(i) == '-'))
                        {
                            _minus = true;
                        }
                        else _operators += s.charAt(i);
                    }
                    else
                    {
                        _incorrect = true;
                        System.out.println("Input data is invalid!");
                        return;
                    }
                }

                if (str != "" && Integer.parseInt(str) <= 10)
                {
                    if (_minus) {
                        _masNum[index] = Integer.parseInt(str) * (-1);
                        _minus = false;
                    } else
                        _masNum[index] = Integer.parseInt(str);

                    index++;
                    str = "";
                }
                else if(str != "" && Integer.parseInt(str) > 10)
                {
                    _incorrect = true;
                    System.out.println("Input data is invalid!");
                    return;
                }
            }
        }

        return;
    }
    //////////////////////////////////

   private  boolean  isOperator(char ch)
   {
       if(ch == '+' || ch == '*' || ch == '/' || ch == '-')
          return true;
       else
           return false;
   }
}
