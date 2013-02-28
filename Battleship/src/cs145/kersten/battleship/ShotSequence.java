package cs145.kersten.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class ShotSequence
{
    public static void main(String[] args)
    {
        ShotSequence parentOne = new ShotSequence();
        parentOne.randomize();
        System.out.println("ParentOne:");
        System.out.println(parentOne.toString());
        System.out.println();
        
        ShotSequence parentTwo = new ShotSequence();
        parentTwo.randomize();
        System.out.println("ParentTwo:");
        System.out.println(parentTwo.toString());
        System.out.println();
        
        ShotSequence blah = new ShotSequence();
        blah.minimalCross(parentOne, parentTwo, 10);
    }
    
    public final static int LENGTH = 5;
    public final static int MUTATE = 10;
    
    public static Random random = new Random();
    
    public byte[] sequence;
    public float fitness;
    
    public ShotSequence()
    {
        sequence = new byte[LENGTH];
        initializeSequence();
    }
    
    public void randomize()
    {
        ArrayList<Byte> shuffler = new ArrayList<Byte>(LENGTH);
        
        for (byte i = 0; i < LENGTH; i++)
        {
            shuffler.add((byte) i);
        }
        
        Collections.shuffle(shuffler);
        
        for (int i = 0; i < LENGTH; i++)
        {
            sequence[i] = shuffler.get(i);
        }
    }
    
    public void minimalCross(ShotSequence parentOne, ShotSequence parentTwo, int reduction)
    {
        for (int i = 0; i < reduction; i++)
        {
            ShotSequence sequence = new ShotSequence();
            sequence.cross(parentOne, parentTwo);
            // sequence.mutateSwap();
            System.out.println(sequence);
            parentTwo = sequence;
        }
    }
    
    public void cross(ShotSequence p1, ShotSequence p2)
    {
        boolean useP1 = true;
        int p1Index = 0;
        int p2Index = 0;
        
        for (int i = 0; i < LENGTH; i++)
        {
            if (useP1)
            {
                if (p1Index == LENGTH)
                {
                    useP1 = false;
                    i--;
                    continue;
                }
                
                if (contains(p1.sequence[p1Index]))
                {
                    p1Index++;
                    i--;
                    useP1 = false;
                    continue;
                }
                
                sequence[i] = p1.sequence[p1Index];
                p1Index++;
                useP1 = false;
            }
            else
            {
                if (p2Index == LENGTH)
                {
                    useP1 = true;
                    i--;
                    continue;
                }
                
                if (contains(p2.sequence[p2Index]))
                {
                    p2Index++;
                    i--;
                    useP1 = true;
                    continue;
                }
                
                sequence[i] = p2.sequence[p2Index];
                p2Index++;
                useP1 = true;
            }
        }
    }
    
    public void mutateSwap()
    {
        for (int i = 0; i < LENGTH; i++)
        {
            if (random.nextInt(MUTATE) == 0)
            {
                byte valueAtI = sequence[i];
                int randIndex = random.nextInt(LENGTH);
                byte ValueAtRandIndex = sequence[randIndex];
                
                sequence[i] = ValueAtRandIndex;
                sequence[randIndex] = valueAtI;
            }
        }
    }
    
    public void mutateShiftForward(int index)
    {
        if (index == 0) return;
        if (index == 1)
        {
            byte temp = sequence[0];
            sequence[0] = sequence[1];
            sequence[1] = temp;
            return;
        }
        
        byte value = sequence[index];
        int displacement = random.nextInt(index - 1) + 1;
        
        for (int i = 0; i < displacement ; i++)
        {
            sequence[index - i] = sequence[(index - i) - 1];
        }
        sequence[index - displacement] = value;
    }
    
    public void mutateShiftBack()
    {
        
    }
    
    public void calculateFitness(int gameResult, int turns, int numberHits)
    {
//        switch (gameResult)
//        {
//            case WON:
//                fitness = turns;
//                return;
//            case LOST:
//                fitness = turns * (1.0f / ((float) numberHits / 17.0f));
//                return;
//        }
    }
    
    public boolean contains(byte value)
    {
        for (int i = 0; i < LENGTH; i++)
        {
            if (sequence[i] == value)
            {
                return true;
            }
        }
        
        return false;
    }
    
    private void initializeSequence()
    {
        Arrays.fill(sequence, (byte) -1);
    }
    
    @Override
    public String toString()
    {
        String result = "[" + sequence[0];
        for (int i = 1; i < LENGTH; i++)
        {
            //if (sequence[i] < 10) result += ", 0" + sequence[i];
            //else result += ", " + sequence[i];
            
            result += ", " + sequence[i];
        }
        result += "]";
        return result;
    }
}