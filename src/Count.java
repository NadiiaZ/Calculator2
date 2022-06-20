public class Count {
    private Operators _operator = new Operators();
    private String _str = new String();
    private int _result;
    private boolean _incorrect = false;

    public void count ()
    {
        int _mas [] = new int [3];

        _operator.findNumber(_str);

        _incorrect = _operator._incorrect;
        if(_incorrect)
            return;

        _mas = _operator._masNum;
        String _op = _operator._operators;
        _result = 0;


        if(_op.length() > 1)
        {
            if((_op.charAt(0) == '-' || _op.charAt(0) == '+')&&
                (_op.charAt(_op.length() - 1) == '/' || _op.charAt(_op.length() - 1) == '*'))
            {
                _result =  chooseOperator(_op.charAt(_op.length() - 1), _mas[1], _mas[2]);
                if(!_incorrect)
                _result =  chooseOperator(_op.charAt(0), _mas[0], _result);
                else return;
            }
            else
            {
                _result =  chooseOperator(_op.charAt(0), _mas[0], _mas[1]);
                if(!_incorrect)
                     _result =  chooseOperator(_op.charAt(_op.length() - 1), _result, _mas[2]);
                else return;
            }
        }
        else
            _result =  chooseOperator(_op.charAt(_op.length() - 1), _mas[0], _mas[1]);

    }

    private int chooseOperator(char ch, int _num1, int _num2)
    {
        int result = 0;
        switch (ch)
        {
            case '+': result =  (_num1) + (_num2); break;
            case '-':
            {
                if (_num1 <0 && _num2 < 0)
                    result = (Math.abs(_num1) + Math.abs(_num2)) * -1 ;
                else
                    result = _num1 - Math.abs(_num2);
            } break;
            case '*': result = (_num1) * (_num2); break;
            case '/':
            {
                if(_num2 == 0)
                {
                    System.out.println("You cannot divide by 0");
                    _incorrect = true;
                    return 0;
                }
                else result = (_num1) /(_num2); break;
            }
        }
        return result;
    }

    public void input(String s)
    {
        _str = s;
    }
   public void outPut()
   {
       count();
       if(!_incorrect)
       {
           System.out.println("Result: "+ _result);
       }
   }
}
