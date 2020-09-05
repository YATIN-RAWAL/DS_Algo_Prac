public class Dequeue
{
    int data[];
    int size;
    int front;
    int rear;
    Dequeue(int capacity)
    {
        data=new int[capacity];
        size=0;
        front=rear=-1;
    }
    void insertFront(int element)
    {
        if(size==data.length)
        {
            System.out.println(-1);
            return;
        }
        else
        {
            if(front==-1)
            {
                front=rear=0;
            }
            else if(front==0)
                front=data.length-1;
            else
                front--;
            data[front]=element;
            size++;
        }
    }
    void insertRear(int element)
    {
        if(size==data.length)
        {
            System.out.println(-1);
            return;
        }
        else
        {
            if(rear==-1)
                front=rear=0;
            else if(rear==data.length-1)
                rear=0;
            else
                rear++;
            data[rear]=element;
            size++;
        }
    }
    void deleteFront()
    {
        if(size==0)
        {
            System.out.println(-1);
            return;
        }
        if(front==rear)
            front=rear=0;
        else
        {
            if(front==data.length-1)
                front=0;
            else
                front++;
        }
        size--;
    }
    void deleteRear()
    {
        if(size==0)
        {
            System.out.println(-1);
            return;
        }
        if(front==rear)
            front=rear=0;
        else
        {
            if(rear==0)
                rear=data.length-1;
            else
                rear--;
        }
        size--;
    }
    int getFront()
    {
        if(size==0)
            return -1;
        else
            return data[front];
    }
    int getRear()
    {
        if(size==0)
            return -1;
        else
            return data[rear];
    }
}