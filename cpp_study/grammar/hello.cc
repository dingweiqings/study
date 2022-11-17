#include <algorithm>
#include <vector>
#include <list>
#include <map>
#include <set>
#include <string>
#include <queue>
#include <stack>
#include <array>
#include <stdio.h>
#include <iostream>
#include <memory>
using namespace std;
int main()
{
    printf("Hello world!");
    cout << "ccc" << endl;
    cout << "Hello world!" << endl;
    char buff[100]={0};
    vector<int> *int_vector = new vector<int>(5);

    // vector<int>  int_vector1(5);
    for (int i = 0; i < 10; i++)
    {
        int_vector->insert(int_vector->begin(), 10);
    }

    vector<int>::iterator it = int_vector->begin();
        while (it != int_vector->end())
    {
        cout << *it << endl;
        it++;
    }
    vector<int> vec;
   vec.push_back(5);

    //10,10,...,10,0,0
    transform(int_vector->begin(),int_vector->end(),back_inserter(vec),[](int x){return x+1;});


    for(int it:vec){
            cout<<"Enhanced for"<<it<<endl;
    }

    // list<int> list(10);
    // for (int i = 0; i < 10; i++)
    // {
    //     list.push_front(i);
    // }
    
    map<int,string> map_d;
    map_d[0]="111";
    map_d[1]="222";
     map_d[-1]="222";
    for(auto x:map_d){
          cout<<x.first<<x.second<<endl;
    }
    bool result=map_d.find(78)==map_d.end();
    cout<<"Find "<<result<<endl;
    
    

    return 0;
}