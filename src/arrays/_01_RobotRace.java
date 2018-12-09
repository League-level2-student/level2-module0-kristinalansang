package arrays;

import org.jointheleague.graphical.robot.Robot;
import java.util.Random;
public class _01_RobotRace {
	//1. make a main method
	public static void main(String[] args)
	{
	//2. create an array of 5 robots.
	Robot[] robots = new Robot[5];
	//3. use a for loop to initialize the robots.
	for(int i = 0; i < 5; i++)
	{
		robots[i] = new Robot();
		//4. make each robot start at the bottom of the screen, side by side, facing up
		robots[i].moveTo(i * 100, 500);
	}
	//5. use another for loop to iterate through the array and make each robot move 
	//   a random amount less than 50.
	Random gen = new Random();
	for(int i = 0; i < 5; i++)
	{
		final int i1 = i;
		new Thread(()->robots[i1].move(gen.nextInt(50))).start();
	}
	//6. use a while loop to repeat step 5 until a robot has reached the top of the screen.
	boolean top = false;
	int winner = 0;
	while(!top)
	{
		for(int i = 0; i < 5; i++)
		{
			final int i1 = i;
			new Thread(()->robots[i1].move(gen.nextInt(50))).start();
			if(robots[i].getY() <= 50)
			{
				top = true;
				winner = i;
			}
		}
	}
	//7. declare that robot the winner and throw it a party!
	System.out.println("Robot " + winner + " is the winner");
	robots[winner].sparkle();
	//8. try different races with different amounts of robots.
	Robot[] robots1 = new Robot[7];

	for(int i = 0; i < 7; i++)
	{
		robots1[i] = new Robot();
		robots1[i].moveTo(i * 100, 500);
	}

	for(int i = 0; i < 5; i++)
		robots[i].move(gen.nextInt(50));
	boolean top1 = false;
	int winner1 = 0;
	while(!top1)
	{
		for(int i = 0; i < 5; i++)
		{
			robots1[i].move(gen.nextInt(50));
			if(robots1[i].getY() <= 50)
			{
				top1 = true;
				winner1 = i;
			}
		}
	}
	System.out.println("Robot " + winner1 + " is the winner");
	robots[winner1].sparkle();
	//9. make the robots race around a circular track.
	
	}
}
