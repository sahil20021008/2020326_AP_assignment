import java.util.*;

class vaccine{
	private int no_doses;
	private String name;
	private int gap;
	public int get_no() {
		return this.no_doses;
	}
	public void set_no(int dose) {
		this.no_doses=dose;
	}
	public String get_name() {
		return this.name;
	}
	public void set_name(String new_name) {
		this.name=new_name;
	}
	public int get_gap() {
		return this.gap;
	}
	public void set_gap(int gape) {
		this.gap=gape;
	}
	public vaccine(String name,int no,int gap) {
		this.set_gap(gap);
		this.set_name(name);
		this.set_no(no);
	}
}
class slots{
	private int day_no;
	private int quantity;
	private vaccine v;
	public int get_day() {
		return this.day_no;
	}
	public void set_day(int day) {
		this.day_no=day;
	}
	public int get_quantity() {
		return this.quantity;
	}
	public void set_quantity(int quantity) {
		this.quantity=quantity;
	}
	public vaccine get_vaccine() {
		return this.v;
	}
	public void set_vaccine(vaccine vac) {
		this.v=vac;
	}
	public slots(int day,int q,vaccine v) {
		this.set_day(day);
		this.set_quantity(q);
		this.set_vaccine(v);
	}
}
class hospital{
	public static int hospi_id=100000;
	private String name;
	private int pincode;
	private int hosp_id;
	private ArrayList<slots>slot=new ArrayList<slots>();
	public int get_pin() {
		return this.pincode;
	}
	public void set_pin(int pin) {
		this.pincode=pin;
	}
	public String get_name() {
		return this.name;
	}
	public void set_name(String new_name) {
		this.name=new_name;
	}
	public int get_id() {
		return this.hosp_id;
	}
	public void set_id(int new_id) {
		this.hosp_id=new_id;
	}
	public ArrayList<slots> get_slots(){
		return this.slot;
	}
	public hospital(String name,int pin) {
		this.set_id(hospi_id++);
		this.set_name(name);
		this.set_pin(pin);
	}
	public void create_slots(int day,int q,vaccine v) {
		ArrayList<slots>s=this.get_slots();
		s.add(new slots(day,q,v));
	}
	public void register() {
		System.out.println("Hospital Name: "+this.get_name()+", PinCode: "+this.get_pin()+", Unique ID: "+this.get_id());
	}
}
class client{
	private int age;
	private String name;
	private long id;
	private String vaccination_status;
	private vaccine vaccine;
	private int last_date;
	private int next_date;
	private int no_of_doses;
	public int get_age() {
		return this.age;
	}
	public void set_age(int new_age) {
		this.age=new_age;
	}
	public String get_name() {
		return this.name;
	}
	public void set_name(String new_name) {
		this.name=new_name;
	}
	public long get_id() {
		return this.id;
	}
	public void set_id(long new_id) {
		this.id=new_id;
	}
	public String get_status() {
		return this.vaccination_status;
	}
	public void set_status(String new_status) {
		this.vaccination_status=new_status;
	}
	public vaccine get_vaccine() {
		return this.vaccine;
	}
	public void set_vaccine(vaccine v) {
		this.vaccine=v;
	}
	public int get_last() {
		return this.last_date;
	}
	public void set_last(int new_last) {
		this.last_date=new_last;
	}
	public int get_next() {
		return this.next_date;
	}
	public void set_next(int new_next) {
		this.next_date=new_next;
	}
	public int get_no() {
		return this.no_of_doses;
	}
	public void set_no(int new_no) {
		this.no_of_doses=new_no;
	}
	public client(String name,int age,long id) {
		this.set_age(age);
		this.set_name(name);
		this.set_id(id);
		this.set_status("REGISTERED");
		this.set_vaccine(null);
		this.set_no(0);
		this.set_last(0);
		this.set_next(0);
	}
	public void book_slot(vaccine v,int day_no,int due) {
		if(this.get_status().equalsIgnoreCase("REGISTERED")) {
			this.set_vaccine(v);
			this.set_no(this.get_no()+1);
			if(this.get_no()==v.get_no()) {
				this.set_status("FULLY VACCINATED");
			}else {
				this.set_status("PARTIALLY VACCINATED");
			}
			this.set_last(day_no);
			this.set_next(due+day_no);
		}else if (this.get_status().equalsIgnoreCase("PARTIALLY VACCINATED")) {
			if(this.get_vaccine()!=v) {
				System.out.println("error: you are trying to book different vaccines please try again");
				return;
			}
			this.set_no(this.get_no()+1);
			if(this.get_no()==this.get_vaccine().get_no()) {
				this.set_status("FULLY VACCINATED");
				this.set_last(day_no);
			}else {
				this.set_last(day_no);
				this.set_next(due+day_no);
			}
		}else {
			System.out.println("error:you have already been fully vaccinated");
		}
	}
	public void check_vaccination_status() {
		if(this.get_status().equalsIgnoreCase("REGISTERED")) {
			System.out.println("citizen REGISTERED");
		}else if (this.get_status().equalsIgnoreCase("PARTIALLY VACCINATED")) {
			System.out.println("PARTIALLY VACCINATED"+"\nVaccine given:"+this.get_vaccine().get_name()+"\nNo of doses given: "+this.get_no()+"\nNext dose due date: "+this.get_next());
		}else {
			System.out.println("FULLY VACCINATED\nVaccine Given: "+this.get_vaccine().get_name()+"\nNumber of doses given: "+this.get_no());
		}
	}
}
public class A1_2020326 {
	public static client search(ArrayList<client>c,long id) {
		client ans = null;
		for(int i=0;i<c.size();i++) {
			if(c.get(i).get_id()==id) {
				ans=c.get(i);
				break;
			}
		}
		return ans;
	}
	public static hospital searcher(ArrayList<hospital>h,int id) {
		hospital ans=null;
		for(int i=0;i<h.size();i++) {
			if(h.get(i).get_id()==id) {
				ans=h.get(i);
				break;
			}
		}
		return ans;
	}
	public static int counter(long id) {
		int count=0;
		while(id!=0) {
			id=id/10;
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		ArrayList<hospital>hosp=new ArrayList<hospital>();
		ArrayList<client>cli=new ArrayList<client>();
		ArrayList<vaccine>vac=new ArrayList<vaccine>();
		System.out.println("CoWin Portal initialized....\n");
		while (true) {
			System.out.println("\n---------------------------------\n"+"1. Add Vaccine\n"
					+ "2. Register Hospital\n"
					+ "3. Register Citizen\n"
					+ "4. Add Slot for Vaccination\n"
					+ "5. Book Slot for Vaccination\n"
					+ "6. List all slots for a hospital\n"
					+ "7. Check Vaccination Status\n"
					+ "8. Exit\n"+"---------------------------------\n");
			int n=Integer.parseInt(scan.nextLine());
			if(n==1) {
				System.out.println("Vaccine Name:");
				String name=scan.nextLine();
				System.out.println("Number of Doses:");
				int no=Integer.parseInt(scan.nextLine());
				int gap;
				if(no==1) {
					gap=0;
				}else {
					System.out.println("Gap between Doses:");
					gap=Integer.parseInt(scan.nextLine());
				}
				vaccine v=new vaccine(name, no, gap);
				vac.add(v);
				System.out.println("Vaccine Name: "+v.get_name()+",Number of Doses: "+v.get_no()+", Gap Between Doses: "+v.get_gap());
			}else if (n==2) {
				System.out.println("Hospital Name:");
				String s=scan.nextLine();
				System.out.println("PinCode:");
				int pin=Integer.parseInt(scan.nextLine());
				hospital h=new hospital(s, pin);
				h.register();
				hosp.add(h);
			}else if (n==3) {
				System.out.println("Citizen name:");
				String s=scan.nextLine();
				System.out.println("Age:");
				int age=Integer.parseInt(scan.nextLine());
				System.out.println("Unique id:");
				long id=Long.parseLong(scan.nextLine());
				client check=search(cli, id);
				if(check!=null) {
					System.out.println("error id is not unique \nPlease try again");
					continue;
				}
				client c=new client(s,age,id);
				int counter=counter(id);
				System.out.print("Citizen name: "+c.get_name()+", Age: "+c.get_age()+", Unique ID: ");//+c.get_id());//form);//c.get_id());
				while(counter<12) {
					System.out.print("0");
					counter++;
				}
				System.out.println(c.get_id());
				if(age<18) {
					System.out.println("Only above 18 are allowed");
					continue;
				}
				cli.add(c);
			}else if (n==4) {
				System.out.println("Enter Hospital ID:");
				int id=Integer.parseInt(scan.nextLine());
				hospital h=searcher(hosp, id);
				if(h==null) {
					System.out.println("error: incorrect hospital id: please try again");
					continue;
				}
				System.out.println("Enter number of Slots to be added:");
				int slotter=Integer.parseInt(scan.nextLine());
				for(int alpha=0;alpha<slotter;alpha++) {
					System.out.println("Enter Day Number:");
					int day_no=Integer.parseInt(scan.nextLine());
					System.out.println("Enter Quantity:");
					int q=Integer.parseInt(scan.nextLine());
					System.out.println("Select Vaccine");
					for(int beta=0;beta<vac.size();beta++) {
						System.out.println(beta+". "+vac.get(beta).get_name());
					}
					int vaccine=Integer.parseInt(scan.nextLine());
					vaccine r=vac.get(vaccine);
					boolean valt=false;
					for(int gamma=0;gamma<h.get_slots().size();gamma++) {
						if(h.get_slots().get(gamma).get_vaccine()==r&&h.get_slots().get(gamma).get_day()==day_no) {
							System.out.println("error: you cannot create new slot for same vaccine on same day \nPlease try again");
							valt=true;
							break;
						}
					}
					if(valt==true) {
						continue;
					}
					h.create_slots(day_no, q, r);
					System.out.println("Slot added by Hospital "+id+" for Day: "+day_no+", Available Quantity: "+q+" of Vaccine "+r.get_name());
				}
			}else if(n==5){
				System.out.println("Enter patient Unique ID:");
				long id=Long.parseLong(scan.nextLine());
				client c=search(cli, id);
				if(c==null) {
					System.out.println("incorrect client id entered\nPlease try again:\n");
				}
				System.out.println("1. Search by area\n" + "2. Search by Vaccine\n" + "3. Exit\n");
				System.out.println("Enter option:");
				int choice=Integer.parseInt(scan.nextLine());
				String name = null;
				if(choice==1) {
					System.out.println("Enter PinCode:");
					int pin=Integer.parseInt(scan.nextLine());
					for(int alpha=0;alpha<hosp.size();alpha++) {
						if(hosp.get(alpha).get_pin()==pin) {
							System.out.println(hosp.get(alpha).get_id()+" "+hosp.get(alpha).get_name());
						}
					}
				}else if (choice==2) {
					System.out.println("Enter Vaccine name:");
					name=scan.nextLine();
					for(int alpha=0;alpha<hosp.size();alpha++) {
						for(int beta=0;beta<hosp.get(alpha).get_slots().size();beta++) {
							if(name.equalsIgnoreCase(hosp.get(alpha).get_slots().get(beta).get_vaccine().get_name())) {
								System.out.println(hosp.get(alpha).get_id()+" "+hosp.get(alpha).get_name());
								break;
							}
						}
					}
				}else if(choice==3){
					continue;
				}else {
					System.out.println("incorrect choice input \nPlease try again");
					continue;
				}
				System.out.println("Enter hospital id:");
				int hospit_id=Integer.parseInt(scan.nextLine());//Reader.nextint();
				hospital hospi=searcher(hosp, hospit_id);
				if(hospi==null) {
					System.out.println("incorrect hospital id\nPlease try again:\n");
					continue;
				}
				boolean value=false;
				for(int alpha=0;alpha<hospi.get_slots().size();alpha++) {
					if(c.get_next()>hospi.get_slots().get(alpha).get_day()) {
						continue;
					}
					value=true;
					if(choice==1) {
						System.out.println(alpha+"-> Day:"+hospi.get_slots().get(alpha).get_day()+"Available Qty:"+hospi.get_slots().get(alpha).get_quantity()+"Vaccine:"+hospi.get_slots().get(alpha).get_vaccine().get_name());
					}else if (choice==2) {
						if(hospi.get_slots().get(alpha).get_vaccine().get_name().equalsIgnoreCase(name)) {
							System.out.println(alpha+"-> Day:"+hospi.get_slots().get(alpha).get_day()+" Available Qty:"+hospi.get_slots().get(alpha).get_quantity()+" Vaccine:"+hospi.get_slots().get(alpha).get_vaccine().get_name());
						}
					}
				}
				if(value==false) {
					System.out.println("No slots available");
					continue;
				}
				System.out.println("Choose Slot:");
				int slot=Integer.parseInt(scan.nextLine());
				slots s=hospi.get_slots().get(slot);
				if(s.get_quantity()<=0) {
					System.out.println("quantity of vaccine is 0 \nPlease select another slot");
					continue;
				}
				s.set_quantity(s.get_quantity()-1);
				c.book_slot(s.get_vaccine(),s.get_day(),s.get_vaccine().get_gap());
				System.out.println(c.get_name()+" vaccinated with "+s.get_vaccine().get_name());
			}else if (n==6) {
				System.out.println("Enter Hospital Id:");
				int hospi_id=Integer.parseInt(scan.nextLine());
				hospital hospi=searcher(hosp, hospi_id);
				if(hospi==null) {
					System.out.println("incorrect hospital id");
					continue;
				}
				for(int alpha=0;alpha<hospi.get_slots().size();alpha++) {
					System.out.println("Day: "+hospi.get_slots().get(alpha).get_day()+" Vaccine: "+hospi.get_slots().get(alpha).get_vaccine().get_name()+" Available Qty: "+hospi.get_slots().get(alpha).get_quantity());
				}
			}else if (n==7) {
				System.out.println("Enter Patient ID:");
				long id=Long.parseLong(scan.nextLine());
				client c=search(cli, id);
				if(c==null) {
					System.out.println("error:no such client, incorrect id input");
				}else {
					c.check_vaccination_status();
				}
			}else if (n==8) {
				break;
			}else {
				System.out.println("Incorrect choice input, please try again");
			}
		}
		System.out.println("end of test case");
		scan.close();
	}
}
