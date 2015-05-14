class Timer
{
  int timerStart;
  int currentTime;
  
  Timer() {
    timerStart = millis(); 
  }
  
  // You pass a number of milliseconds, it checks if
  // that amount of time has passed yet
  boolean check(int check)
  {
    boolean result = false;
    
    currentTime = millis();
    if ( currentTime - timerStart > check)
    {
      result = true;
    }
    else
    {
      result = false;
    }
    
    return result;
  }
  
  // Resets the timer
  void reset()
  {
   timerStart = millis(); 
  }
}
