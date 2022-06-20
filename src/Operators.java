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

        for(int i = 0; i <= s.length(); i++) {

            if (i < s.length() && Character.isDigit(s.charAt(i))) {
                str += s.charAt(i);
            }
            else
            {
                if (i < s.length())
                {
                    if (isSpace(s, i))
                    {
                        i++;
                        _operators += s.charAt(i);
                        i++;
                    } else {
                        _incorrect = true;
                        System.out.println("Input data is invalid!");
                        return;
                    }
                }
                if(writeNumber(str, index))
                {
                    index ++;
                    str = "";
                }
            }
        }
    }
    //////////////////////////////////

   private  boolean  isOperator(char ch)
   {
       if(ch == '+' || ch == '*' || ch == '/' || ch == '-')
          return true;
       else
           return false;
   }

   private boolean isSpace(String s, int idx)
   {
       if(idx >= 0 && idx < s.length() - 1)
       {
           if(s.charAt(idx) == ' ' && s.charAt(idx + 2) == ' ' && isOperator(s.charAt(idx + 1)))
               return true;
       }
       else
         return false;

       return false;
   }

   private boolean writeNumber(String str, int index)
   {
       if (str != "" && Integer.parseInt(str) <= 10)
       {
           _masNum[index] = Integer.parseInt(str);
           return true;
       }
       else if (str != "" && Integer.parseInt(str) > 10)
           {
           _incorrect = true;
           System.out.println("Input data is invalid!");
           }
       return false;
   }
}

