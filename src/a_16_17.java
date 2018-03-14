import java.util.ArrayList;

public class a_16_17
{
    /* Write a method called removeRange that accepts a starting and ending index as parameters and removes the
    elements at those indexes (inclusive) from the list.
    For example, if a variable list stores the values
    [8, 13, 17, 4, 9, 12, 98, 41, 7, 23, 0, 92], the call of listRange.removeRange(3, 8); should remove values
    between index 3 and index 8 (the values 4 and 7), leaving the list of [8, 13, 17, 23, 0, 92].
    The method should throw an IllegalArgumentException if either of the positions is negative. Otherwise you may assume
    that the positions represent a legal range of the list (0 <= start <= end <= size). */

    //initiate standard variables
    private ListNode front;

    //too test the method
    public void run()
    {
        //I have made an add-method to ListNode
        addNodeToList(0,8);
        addNodeToList(1,13);
        addNodeToList(2,17);
        addNodeToList(3,4);
        addNodeToList(4,9);
        addNodeToList(5,12);
        addNodeToList(6,98);
        addNodeToList(7,41);
        addNodeToList(8,7);
        addNodeToList(9,23);
        addNodeToList(10,0);
        addNodeToList(11,92);

        //I have made a print list data method
        printList();
        removeRange(3,8);
        printList();
    }

    //remove data in the range of the index
    public void removeRange(int start,int end)
    {
        //initiate variables
        ArrayList<Integer> holder = new ArrayList<>();

        //the for-loop adds fronts value to the arraylist holder.
        for (ListNode current = front; current != null; current = current.next)
        {
            holder.add(current.data);
        }

        // legal range of the list is (0 <= start <= end <= size), if not throw exception
        if (start < 0 || end < start || end > holder.size())
        {
            throw new IllegalArgumentException();
        }

        //remove from the index
        for (int i = start; i <= end; i++)
        {
            holder.remove(i);
            i--;
            end--;
        }

        //the for-loop set all nodes to null
        for (ListNode current = front; front != null; current = current.next)
        {
            //the reason for at check the next node is to avoid NullPointerException!
            if (current.next.next == null)
            {
                current.next = null;
            }
            if (current.next == null)
            {
                front = null;
            }
        }

        //adds the data from array to list(front) with the add method
        for (int i = 0; i < holder.size(); i++)
        {
            addNodeToList(i,holder.get(i));
        }
    }

    //an add-method to ListNode that adds a value to the list
    public void addNodeToList(int index, int value)
    {
        //if index is 0, then add value to front
        if(index == 0)
        {
            front = new ListNode(value, front);
        }
        // else add a value to the end of list
        else
        {
            ListNode current = front;
            for (int i = 0; i < index-1; i++)
            {
                current = current.next;
            }
            current.next = new ListNode(value,current.next);
        }
    }

    //prints the list
    public void printList()
    {
        //the for-loop that prints the list data out
        System.out.print("[ ");
        for (ListNode current = front; current != null; current = current.next)
        {
            System.out.print(current.data + ", ");
        }
        System.out.println("]" + "\n");
    }
}
