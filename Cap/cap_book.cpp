#include<bits/stdc++.h>
using namespace std;

class Cap {

private:
	string name, type;
	int trips_per_employee = 0, amount_per_employee = 0;
public:
	Cap(string n, string t)
	{
		name = n;
		type = t;
	}


	void usecap(int incr, string type)
	{
		trips_per_employee += 1;

		if (type == "software_engineer")
			amount_per_employee += 100;
		else if (type == "Manager")
			amount_per_employee += 200;
		else
			amount_per_employee += 500;
	}




	string getname()
	{
		return name;
	}

	string gettype()
	{
		return type;
	}

	int get_trips_per_employee()
	{
		return trips_per_employee;
	}

	int get_amount_per_employee()
	{
		return amount_per_employee;
	}


};

int  check_name(string name, string type , vector<Cap>&store) {


	for (int i = 0; i < store.size(); i++)
	{
		if (store[i].getname() == name && store[i].gettype() == type)
		{
			return i;
		}
	}

	return -1;

};

int main()
{
	vector<Cap>store;
	int total_amount = 0;

	while (true)
	{
		string name, type;
		int choice;
		cout << "------------------------------------------------------------------" << endl;
		cout << "Enter ur choice" << endl;
		cout << "1) To book a cap" << endl;
		cout << "2) To see particular employee details" << endl;
		cout << "3) Total amount send by company so far" << endl;
		cout << "4) Quit" << endl;
		cout << "------------------------------------------------------------------" << endl;
		cin >> choice;
		if (choice == 1) {
			cout << endl;
			cout << "Enter ur name" << endl;
			cin >> name;
			cout << "Enter ur position in company (software_engineer,Manager,HR)" << endl;
			cin >> type;
			if (type == "software_engineer")
				total_amount += 100;
			else if (type == "Manager")
				total_amount += 200;
			else
				total_amount += 500;
			Cap cp = Cap(name, type);
			if (check_name(name, type, store) == -1)
			{
				store.push_back(cp);
				int ix = store.size() - 1;
				store[ix].usecap(1, type);

			}
			else {
				int index = check_name(name, type, store);
				store[index].usecap(1, type);
			}

		}
		else if (choice == 2) {
			cout << endl;
			cout << "Enter a particular employee name" << endl;
			cin >> name;
			cout << "Enter a particular employee designation" << endl;
			cin >> type;
			bool inside = false;
			cout << endl;
			for (int i = 0; i < store.size(); i++)
			{
				if (store[i].getname() == name && store[i].gettype() == type)
				{
					cout << "Employee name is " << store[i].getname() << " and his designation is " << store[i].gettype() << endl;
					cout << "Total amount of time he used cap -> " << store[i].get_trips_per_employee() << endl;
					cout << "Total amount of spend by this employee is " << store[i].get_amount_per_employee() << endl;
					inside = true;
					break;
				}
			}
			cout << endl;
			if (inside == false)

				cout << "Invalid employee details respectively" << endl;
			cout << endl;

		}
		else if (choice == 3)
		{
			cout << endl;
			cout << "Total amount spend by campany for cap is " << total_amount << endl;
		}
		else
		{
			break;
		}
	}
}