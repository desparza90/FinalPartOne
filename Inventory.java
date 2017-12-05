package inventory;

import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author despa
 */
public class Inventory {

    public static void main(String[] args) {
        
        NodeStack bun = new NodeStack();
        NodeStack patty = new NodeStack();
        NodeStack lettuce = new NodeStack();
        NodeStack tomato = new NodeStack();
        NodeStack onion = new NodeStack();
        NodeStack cheese = new NodeStack();
        
        Llist burger = new Llist();
        burger.add(bun);
        burger.add(patty);
        burger.add(lettuce);
        burger.add(tomato);
        burger.add(onion);
        Llist cBurger = new Llist();
        cBurger.add(cheese);
        cBurger.add(bun);
        cBurger.add(patty);
        cBurger.add(lettuce);
        cBurger.add(tomato);
        cBurger.add(onion);
        Llist vBurger = new Llist();
        vBurger.add(lettuce);
        vBurger.add(lettuce);
        vBurger.add(tomato);
        vBurger.add(onion);
        Llist burgerNO = new Llist();
        burgerNO.add(bun);
        burgerNO.add(patty);
        burgerNO.add(lettuce);
        burgerNO.add(tomato);
        Llist cBurgerNO = new Llist();
        cBurgerNO.add(cheese);
        cBurgerNO.add(bun);
        cBurgerNO.add(patty);
        cBurgerNO.add(lettuce);
        cBurgerNO.add(tomato);
        Llist burgerNT = new Llist();
        burgerNT.add(bun);
        burgerNT.add(patty);
        burgerNT.add(lettuce);
        burgerNT.add(onion);
        
        NodeQueue line = new NodeQueue();
        DictionaryHashTable dc = new DictionaryHashTable();
        
        
        int reSup, nShip, lostCustomerDay, dNum = 1;

        Random rand = new Random();
        nShip = 0;
        
        for(int i = 1201; i <= 1231; i++)
        {
            int countItemOne = 0, countItemTwo = 0, countItemThree = 0, countItemFour = 0, countItemFive = 0, countItemSix = 0;
            int wasteCheese = 0, wasteBun = 0, wastePatty = 0, wasteLettuce = 0, wasteTomato = 0, wasteOnion = 0;
            lostCustomerDay = 0;
            if(nShip == 0)
            {
                    nShip = rand.nextInt(4)+3;
                    reSup =  rand.nextInt(301)+700;
                    addIng(reSup, i, bun, patty, lettuce, tomato, onion, cheese);
            }
            else
                nShip--;
            for(int j = 1; j <= 10; j++){
                int cust = rand.nextInt(100)+1;
                if(cust > 50)
                {
                    lostCustomerDay = lostCustomerDay + (cust - 50);
                    cust = 50;
                }
                for(int k = 1; k <= cust; k++)
                {
                    int order = rand.nextInt(6)+1;
                    //System.out.println("Customer " + k + " order number: " + order);
                    line.enqueue(order);
                }
                
                for(int m = 1; m <= cust; m++)
                {
                    switch((Integer)line.dequeue())
                    {
                        case 1:
                            if(bun.isEmpty() || patty.isEmpty() || lettuce.isEmpty() || tomato.isEmpty() || onion.isEmpty())
                                lostCustomerDay++;
                            else{
                                dc.add(dNum++, 1);
                                bun.pop();
                                patty.pop();
                                lettuce.pop();
                                tomato.pop();
                                onion.pop();
                                countItemOne++;
                            }
                            break;
                        case 2:
                            if(bun.isEmpty() || patty.isEmpty() || lettuce.isEmpty() || tomato.isEmpty() || onion.isEmpty() || cheese.isEmpty())
                                lostCustomerDay++;
                            else{
                                dc.add(dNum++, 2);
                                bun.pop();
                                patty.pop();
                                lettuce.pop();
                                tomato.pop();
                                onion.pop();
                                cheese.pop();
                                countItemTwo++;
                            }
                            break;
                        case 3:
                            if(lettuce.isEmpty() || tomato.isEmpty() || onion.isEmpty() || lettuce.size() < 2)
                                lostCustomerDay++;
                            else{
                                dc.add(dNum++, 3);
                                lettuce.pop();
                                lettuce.pop();
                                tomato.pop();
                                onion.pop();
                                countItemThree++;
                            }
                            break;
                        case 4:
                            if(bun.isEmpty() || patty.isEmpty() || lettuce.isEmpty() || tomato.isEmpty())
                                lostCustomerDay++;
                            else{
                                dc.add(dNum++, 4);
                                bun.pop();
                                patty.pop();
                                lettuce.pop();
                                tomato.pop();
                                countItemFour++;
                            }
                            break;
                        case 5:
                            if(bun.isEmpty() || patty.isEmpty() || lettuce.isEmpty() || tomato.isEmpty() || cheese.isEmpty())
                                lostCustomerDay++;
                            else{
                                dc.add(dNum++, 5);
                                bun.pop();
                                patty.pop();
                                lettuce.pop();
                                tomato.pop();
                                cheese.pop();
                                countItemFive++;
                            }
                            break;
                        case 6:
                            if(bun.isEmpty() || patty.isEmpty() || lettuce.isEmpty() || onion.isEmpty())
                                lostCustomerDay++;
                            else{
                                dc.add(dNum++, 6);
                                bun.pop();
                                patty.pop();
                                lettuce.pop();
                                onion.pop();
                                countItemSix++;
                            }
                            break;
                        }
                    }
                }
            line.clear();
            
            sort(bun);
            if(!bun.isEmpty()){
                while((Integer) bun.peek() == (i-5))
                {
                    bun.pop();
                    wasteBun++;
                    if(bun.isEmpty())
                        break;
                }
            }
            sort(patty);
            if(!patty.isEmpty()){
                while((Integer) patty.peek() == (i-4))
                {
                    patty.pop();
                    wastePatty++;
                    if(patty.isEmpty())
                        break;
                }
            }
            sort(lettuce);
            if(!lettuce.isEmpty()){
                while((Integer) lettuce.peek() == (i-3))
                {
                    lettuce.pop();
                    wasteLettuce++;
                    if(lettuce.isEmpty())
                        break;
                }
            }
            sort(tomato);
            if(!tomato.isEmpty()){
                while((Integer) tomato.peek() == (i-3))
                {
                    tomato.pop();
                    wasteTomato++;
                    if(tomato.isEmpty())
                        break;
                }
            }
            sort(onion);
            if(!onion.isEmpty()){
                while((Integer) onion.peek() == (i-5))
                {
                    onion.pop();
                    wasteOnion++;
                    if(onion.isEmpty())
                        break;
                }
            }
            sort(cheese);
            if(!cheese.isEmpty())
            {                
                while((Integer) cheese.peek() == (i-2))
                {
                    cheese.pop();
                    wasteCheese++;
                    if(cheese.isEmpty())
                        break;
                }
            }
            
            System.out.println("December " + (i-1200) + ":");
            System.out.println("Customers Lost today: " + lostCustomerDay);
            System.out.println("Wasted Cheese: " + wasteCheese);
            System.out.println("Wasted Buns: " + wasteBun);
            System.out.println("Wasted Patties: " + wastePatty);
            System.out.println("Wasted Lettuce: " + wasteLettuce);
            System.out.println("Wasted Tomatos: " + wasteTomato);
            System.out.println("Wasted Onions: " + wasteOnion);
            System.out.println("Burgers sold: " + countItemOne);
            System.out.println("Cheeseburgers sold: " + countItemTwo);
            System.out.println("Vegan Lettuce Wrap Burgers sold: " + countItemThree);
            System.out.println("Burgers (no Onion) sold: " + countItemFour);
            System.out.println("Cheeseurgers (no Onion) sold: " + countItemFive);
            System.out.println("Burgers (no Tomato) sold: " + countItemSix);
            
            Iterator<Integer> kI = dc.getKeyIterator();
            Iterator<Integer> vI = dc.getValueIterator();
            
            while(kI.hasNext())
            {
                System.out.println("Customer " + kI.next() + 
                        " ordered a #" + vI.next());
            }
            System.out.println();
            dc.clear();
            dNum = 1;
        }
    }
    
    public static void addIng(int amount, int date, NodeStack bun, NodeStack patty, NodeStack lettuce, 
            NodeStack tomato, NodeStack onion, NodeStack cheese)
    {
        for(int i = 1; i <= amount; i++)
        {
            Random rand = new Random();
            int item = rand.nextInt(6)+1;
            switch(item){
                case 1: bun.push(date);
                case 2: patty.push(date);
                case 3: lettuce.push(date);
                case 4: tomato.push(date);
                case 5: onion.push(date);
                case 6: cheese.push(date);
            }
                
        }
    }   
    public static void sort(NodeStack st)
    {
        NodeStack tSt = new NodeStack();
            while(st.isEmpty()== false){
                int tmp = (Integer) st.pop();
                while(!tSt.isEmpty() && (Integer) tSt.peek() < tmp) {
                st.push(tSt.pop());
            }
            tSt.push(tmp);
            }
            st = tSt;
    }  
}
