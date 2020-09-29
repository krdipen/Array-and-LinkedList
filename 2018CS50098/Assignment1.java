import java.io.*;

interface Position_<T>
{
    public T value();
    public Position_<T> after();
}

class Position<T> implements Position_<T>
{
    T data;
    Position<T> next;
    public T value()
    {
        return data;
    }
    public Position<T> after()
    {
        return next;
    }
}

interface LinkedList_<T>
{
    public Position_<T> add(T e);
    public Iterator<T> positions();
    public int count();
}

class Iterator<T>
{
    Position<T> current;
    public Iterator(Position<T> head)
    {
        current=head;
    }
    public boolean hasnext()
    {
        if(current!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Position<T> next()
    {
        if(hasnext())
        {
            Position<T> node=current;
            current=current.next;
            return node;
        }
        else
        {
            return null;
        }
    }
}

class LinkedList<T> implements LinkedList_<T>
{
    Position<T> head;
    public LinkedList()
    {
        head=null;
    }
    public Position<T> add(T e)
    {
        Position<T> node=new Position<T>();
        node.data=e;
        node.next=null;
        if(head==null)
        {
            head=node;
        }
        else
        {
            Position<T> node2;
            node2=head;
            while(node2.next!=null)
            {
                node2=node2.next;
            }
            node2.next=node;
        }
        return node;
    }
    public Iterator<T> positions()
    {
        Iterator<T> iterator=new Iterator<T>(head);
        return iterator;
    }
    public int count()
    {
        Iterator<T> iterator=positions();
        int sofar=0;
        while(iterator.hasnext())
        {
            sofar++;
            iterator.next();
        }
        return sofar;
    }
}

interface Entity_
{
    public String name();
    public Iterator<Student> studentList();
}

class Hostel implements Entity_
{
    String name;
    LinkedList<Student> list=new LinkedList<Student>();
    public String name()
    {
        return name;
    }
    public Iterator<Student> studentList()
    {
        return list.positions();
    }
}

class Dept implements Entity_
{
    String name;
    LinkedList<Student> list=new LinkedList<Student>();
    public String name()
    {
        return name;
    }
    public Iterator<Student> studentList()
    {
        return list.positions();
    }
}

class Course implements Entity_
{
    String name;
    String form;
    LinkedList<Student> list=new LinkedList<Student>();
    public String name()
    {
        return name;
    }
    public String form()
    {
        return form;
    }
    public Iterator<Student> studentList()
    {
        return list.positions();
    }
}

interface GradeInfo_
{
   enum LetterGrade
   {
        A, Aminus, B, Bminus, C, Cminus, D, E, F, I;
   }
   public int gradepoint();
}

class GradeInfo implements GradeInfo_
{
    enum LetterGrade
    {
         A, Aminus, B, Bminus, C, Cminus, D, E, F, I;
    }
    public GradeInfo.LetterGrade l;
    public int gradepoint()
    {
        if(l==GradeInfo.LetterGrade.A)
        {
            return 10;
        }
        else if(l==GradeInfo.LetterGrade.Aminus)
        {
            return 9;
        }
        else if(l==GradeInfo.LetterGrade.B)
        {
            return 8;
        }
        else if(l==GradeInfo.LetterGrade.Bminus)
        {
            return 7;
        }
        else if(l==GradeInfo.LetterGrade.C)
        {
            return 6;
        }
        else if(l==GradeInfo.LetterGrade.Cminus)
        {
            return 5;
        }
        else if(l==GradeInfo.LetterGrade.D)
        {
            return 4;
        }
        else if(l==GradeInfo.LetterGrade.E)
        {
            return 0;
        }
        else if(l==GradeInfo.LetterGrade.F)
        {
            return 0;
        }
        else
        {
            return 0;
        }
    }
}

interface CourseGrade_
{
   public String coursetitle();
   public String coursenum();
   public GradeInfo_ grade();
}

class CourseGrade implements CourseGrade_
{
    String coursetitle;
    String coursenum;
    GradeInfo grade=new GradeInfo();
    public String coursetitle()
    {
        return coursetitle;
    }
    public String coursenum()
    {
        return coursenum;
    }
    public GradeInfo grade()
    {
        return grade;
    }
}

interface Student_
{
   public String name();
   public String entryNo();
   public String hostel();
   public String department();
   public String completedCredits();
   public String cgpa();
   public Iterator<CourseGrade> courseList();
}

class Student implements Student_
{
    String name;
    String entryNo;
    String hostel;
    String department;
    int completedCreditsh;
    float cgpah;
    LinkedList<CourseGrade> list=new LinkedList<CourseGrade>();
    public Student()
    {
        completedCreditsh=0;
        cgpah=0;
        LinkedList<CourseGrade> CG_l=new LinkedList<CourseGrade>();
        list=CG_l;
    }
    public String name()
    {
        return name;
    }
    public String entryNo()
    {
        return entryNo;
    }
    public String hostel()
    {
        return hostel;
    }
    public String department()
    {
        return department;
    }
    public String completedCredits()
    {
        return completedCreditsh+"";
    }
    public String cgpa()
    {
        return cgpah+"";
    }
    public Iterator<CourseGrade> courseList()
    {
        return list.positions();
    }
}

public class Assignment1
{
    private static void getData(LinkedList<Hostel> allHostels,LinkedList<Dept> allDepts,LinkedList<Course> allCourses,LinkedList<Student> allStudents,String word1,String word2) throws IOException
    {
        FileReader file1=new FileReader(word1);
        BufferedReader infile1= new BufferedReader(file1);
        String babababa;
        while((babababa=infile1.readLine())!=null)
        {
            String[] tatatata=babababa.split("\\ ");
            String entry_no=tatatata[0];
            String name=tatatata[1];
            String branch=tatatata[2];
            String hostel=tatatata[3];
            Student stu=new Student();
            boolean b=true;
            Iterator<Hostel> iteratorh=allHostels.positions();
            while(iteratorh.hasnext())
            {
                Position<Hostel> tempo=iteratorh.next();
                if(tempo.data.name.equals(hostel))
                {
                    b=false;
                    LinkedList<Student> stu_l=tempo.data.list;
                    stu.name=name;
                    stu.entryNo=entry_no;
                    stu.hostel=hostel;
                    stu.department=branch;
                    stu_l.add(stu);
                    allStudents.add(stu);
                }
            }
            if(b)
            {
                Hostel tempo2=new Hostel();
                tempo2.name=hostel;
                LinkedList<Student> stu_l=new LinkedList<Student>();
                stu.name=name;
                stu.entryNo=entry_no;
                stu.hostel=hostel;
                stu.department=branch;
                stu_l.add(stu);
                allStudents.add(stu);
                tempo2.list=stu_l;
                allHostels.add(tempo2);
            }
            b=true;
            Iterator<Dept> iteratord=allDepts.positions();
            while(iteratord.hasnext())
            {
                Position<Dept> tempo=iteratord.next();
                if(tempo.data.name.equals(branch))
                {
                    b=false;
                    LinkedList<Student> stu_l=tempo.data.list;
                    stu_l.add(stu);
                }
            }
            if(b)
            {
                Dept tempo2=new Dept();
                tempo2.name=branch;
                LinkedList<Student> stu_l=new LinkedList<Student>();
                stu_l.add(stu);
                tempo2.list=stu_l;
                allDepts.add(tempo2);
            }
        }
        FileReader file2=new FileReader(word2);
        BufferedReader infile2=new BufferedReader(file2);
        String cacacaca;
        while((cacacaca=infile2.readLine())!=null)
        {
            String[] tatatata=cacacaca.split("\\ ");
            String entry_no=tatatata[0];
            String c_code=tatatata[1];
            String grade=tatatata[2];
            String c_name=tatatata[3];
            for(int i=4;i<tatatata.length;i++)
            {
                c_name=c_name+" "+tatatata[i];
            }
            boolean b=true;
            Iterator<Course> iteratorc=allCourses.positions();
            while(iteratorc.hasnext())
            {
                Position<Course> tempo=iteratorc.next();
                if(tempo.data.name.equals(c_code))
                {
                    b=false;
                    LinkedList<Student> stu_l=tempo.data.list;
                    Iterator<Student> iterators=allStudents.positions();
                    while(iterators.hasnext())
                    {
                        Position<Student> stup=iterators.next();
                        if(stup.data.entryNo.equals(entry_no))
                        {
                            CourseGrade CG=new CourseGrade();
                            CG.coursetitle=c_name;
                            CG.coursenum=c_code;
                            GradeInfo objgi=new GradeInfo();
                            if(grade.equals("A"))
                            {
                                objgi.l=GradeInfo.LetterGrade.A;
                            }
                            if(grade.equals("Aminus"))
                            {
                                objgi.l=GradeInfo.LetterGrade.Aminus;
                            }
                            if(grade.equals("B"))
                            {
                                objgi.l=GradeInfo.LetterGrade.B;
                            }
                            if(grade.equals("Bminus"))
                            {
                                objgi.l=GradeInfo.LetterGrade.Bminus;
                            }
                            if(grade.equals("C"))
                            {
                                objgi.l=GradeInfo.LetterGrade.C;
                            }
                            if(grade.equals("Cminus"))
                            {
                                objgi.l=GradeInfo.LetterGrade.Cminus;
                            }
                            if(grade.equals("D"))
                            {
                                objgi.l=GradeInfo.LetterGrade.D;
                            }
                            if(grade.equals("E"))
                            {
                                objgi.l=GradeInfo.LetterGrade.E;
                            }
                            if(grade.equals("F"))
                            {
                                objgi.l=GradeInfo.LetterGrade.F;
                            }
                            if(grade.equals("I"))
                            {
                                objgi.l=GradeInfo.LetterGrade.I;
                            }
                            CG.grade=objgi;
                            stup.data.list.add(CG);
                            if((!(grade.equals("I")))&&(!(grade.equals("E")))&&(!(grade.equals("F"))))
                            {
                                stup.data.cgpah=((stup.data.cgpah*stup.data.completedCreditsh+3*objgi.gradepoint())/(stup.data.completedCreditsh+3));
                                stup.data.completedCreditsh=stup.data.completedCreditsh+3;
                            }
                            stu_l.add(stup.data);
                        }
                    }
                }
            }
            if(b)
            {
                Course tempo2=new Course();
                tempo2.name=c_code;
                tempo2.form=c_name;
                LinkedList<Student> stu_l=new LinkedList<Student>();
                Iterator<Student> iterators=allStudents.positions();
                while(iterators.hasnext())
                {
                    Position<Student> stup=iterators.next();
                    if(stup.data.entryNo.equals(entry_no))
                    {
                        CourseGrade CG=new CourseGrade();
                        CG.coursetitle=c_name;
                        CG.coursenum=c_code;
                        GradeInfo objgi=new GradeInfo();
                        if(grade.equals("A"))
                        {
                            objgi.l=GradeInfo.LetterGrade.A;
                        }
                        if(grade.equals("Aminus"))
                        {
                            objgi.l=GradeInfo.LetterGrade.Aminus;
                        }
                        if(grade.equals("B"))
                        {
                            objgi.l=GradeInfo.LetterGrade.B;
                        }
                        if(grade.equals("Bminus"))
                        {
                            objgi.l=GradeInfo.LetterGrade.Bminus;
                        }
                        if(grade.equals("C"))
                        {
                            objgi.l=GradeInfo.LetterGrade.C;
                        }
                        if(grade.equals("Cminus"))
                        {
                            objgi.l=GradeInfo.LetterGrade.Cminus;
                        }
                        if(grade.equals("D"))
                        {
                            objgi.l=GradeInfo.LetterGrade.D;
                        }
                        if(grade.equals("E"))
                        {
                            objgi.l=GradeInfo.LetterGrade.E;
                        }
                        if(grade.equals("F"))
                        {
                            objgi.l=GradeInfo.LetterGrade.F;
                        }
                        if(grade.equals("I"))
                        {
                            objgi.l=GradeInfo.LetterGrade.I;
                        }
                        CG.grade=objgi;
                        stup.data.list.add(CG);
                        if((!(grade.equals("I")))&&(!(grade.equals("E")))&&(!(grade.equals("F"))))
                        {
                            stup.data.cgpah=((stup.data.cgpah*stup.data.completedCreditsh+3*objgi.gradepoint())/(stup.data.completedCreditsh+3));
                            stup.data.completedCreditsh=stup.data.completedCreditsh+3;
                        }
                        stu_l.add(stup.data);
                    }
                }
                tempo2.list=stu_l;
                allCourses.add(tempo2);
            }
        }
    }

    private static void answerQueries(LinkedList<Hostel> allHostels,LinkedList<Dept> allDepts,LinkedList<Course> allCourses,LinkedList<Student> allStudents,String word3) throws IOException
    {
        FileReader file3=new FileReader(word3);
        BufferedReader infile3=new BufferedReader(file3);
        String[] array=new String[999999];
        int index=0;
        String dadadada;
        while((dadadada=infile3.readLine())!=null)
        {
            String[] tatatata=dadadada.split("\\ ");
            String type=tatatata[0];
            if(type.equals("INFO"))
            {
                String identity=tatatata[1];
                Iterator<Student> iterators=allStudents.positions();
                boolean b=true;
                while(iterators.hasnext())
                {
                    Position<Student> stup=iterators.next();
                    if((stup.data.name.equals(identity))||(stup.data.entryNo.equals(identity)))
                    {
                        String one;
                        String[] arraysort=new String[999999];
                        int indexsort=0;
                        b=false;
                        float round1=stup.data.cgpah;
                        int three=(int)(round1*1000);
                        int last=three%10;
                        int two=(three/10);
                        if(last>=5)
                        {
                            two=two+1;
                        }
                        round1=(float)two/100;
                        one=(stup.data.entryNo+" "+stup.data.name+" "+stup.data.department+" "+stup.data.hostel+" "+round1);
                        Iterator<CourseGrade> iteratorcg=stup.data.list.positions();
                        while(iteratorcg.hasnext())
                        {
                            Position<CourseGrade> cgp=iteratorcg.next();
                            arraysort[indexsort]=(" "+cgp.data.coursenum+" "+cgp.data.grade.l);
                            indexsort=indexsort+1;
                        }
                        for(int x=0;x<=indexsort-2;x++)
                        {
                            for(int y=x+1;y<=indexsort-1;y++)
                            {
                                if(arraysort[x].compareTo(arraysort[y])>0)
                                {
                                    String www=arraysort[x];
                                    arraysort[x]=arraysort[y];
                                    arraysort[y]=www;
                                }
                            }
                        }
                        for(int z=0;z<=indexsort-1;z++)
                        {
                            one=one+arraysort[z];
                        }
                        array[index]=one;
                        index=index+1;
                    }
                }
                if(b)
                {
                    array[index]=" ";
                    index=index+1;
                }
            }
            else if(type.equals("SHARE"))
            {
                boolean printable=false;
                String entrynumber=tatatata[1];
                String entityname=tatatata[2];
                Iterator<Hostel> iteratorh=allHostels.positions();
                String one;
                String[] arraysort=new String[999999];
                int indexsort=0;
                while(iteratorh.hasnext())
                {
                    Position<Hostel> hp=iteratorh.next();
                    if(hp.data.name.equals(entityname))
                    {
                        Iterator<Student> iterators=hp.data.list.positions();
                        while(iterators.hasnext())
                        {
                            Position<Student> stup=iterators.next();
                            if(!(stup.data.entryNo.equals(entrynumber)))
                            {
                                arraysort[indexsort]=(stup.data.entryNo+" ");
                                indexsort=indexsort+1;
                            }
                            else
                            {
                                printable=true;
                            }
                        }
                    }
                }
                Iterator<Dept> iteratord=allDepts.positions();
                while(iteratord.hasnext())
                {
                    Position<Dept> dp=iteratord.next();
                    if(dp.data.name.equals(entityname))
                    {
                        Iterator<Student> iterators=dp.data.list.positions();
                        while(iterators.hasnext())
                        {
                            Position<Student> stup=iterators.next();
                            if(!(stup.data.entryNo.equals(entrynumber)))
                            {
                                arraysort[indexsort]=(stup.data.entryNo+" ");
                                indexsort=indexsort+1;
                            }
                            else
                            {
                                printable=true;
                            }
                        }
                    }
                }
                Iterator<Course> iteratorc=allCourses.positions();
                while(iteratorc.hasnext())
                {
                    Position<Course> cp=iteratorc.next();
                    if(cp.data.name.equals(entityname))
                    {
                        Iterator<Student> iterators=cp.data.list.positions();
                        while(iterators.hasnext())
                        {
                            Position<Student> stup=iterators.next();
                            if(!(stup.data.entryNo.equals(entrynumber)))
                            {
                                arraysort[indexsort]=(stup.data.entryNo+" ");
                                indexsort=indexsort+1;
                            }
                            else
                            {
                                printable=true;
                            }
                        }
                    }
                }
                for(int x=0;x<=indexsort-2;x++)
                {
                    for(int y=x+1;y<=indexsort-1;y++)
                    {
                        if(arraysort[x].compareTo(arraysort[y])>0)
                        {
                            String www=arraysort[x];
                            arraysort[x]=arraysort[y];
                            arraysort[y]=www;
                        }
                    }
                }
                if((indexsort!=0)&&(printable))
                {
                    one=arraysort[0];
                    for(int z=1;z<=indexsort-1;z++)
                    {
                        one=one+arraysort[z];
                    }
                    array[index]=one;
                    index=index+1;
                }
                else
                {
                    array[index]=" ";
                    index=index+1;
                }
            }
            else if(type.equals("COURSETITLE"))
            {
                String code=tatatata[1];
                Iterator<Course> iteratorc=allCourses.positions();
                boolean b=true;
                while(iteratorc.hasnext())
                {
                    Position<Course> cp=iteratorc.next();
                    if(cp.data.name.equals(code))
                    {
                        b=false;
                        array[index]=cp.data.form;
                        index=index+1;
                    }
                }
                if(b)
                {
                    array[index]=" ";
                    index=index+1;
                }
            }
        }
        for(int i=index-1;i>=0;i--)
        {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws IOException
    {
        LinkedList<Hostel> allHostels=new LinkedList<Hostel>();
        LinkedList<Dept> allDepts=new LinkedList<Dept>();
        LinkedList<Course> allCourses=new LinkedList<Course>();
        LinkedList<Student> allStudents=new LinkedList<Student>();
        Assignment1 object=new Assignment1();
        object.getData(allHostels,allDepts,allCourses,allStudents,args[0],args[1]);
        object.answerQueries(allHostels,allDepts,allCourses,allStudents,args[2]);
    }
}
