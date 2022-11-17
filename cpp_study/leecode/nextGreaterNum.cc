#include<iostream>
#include<map>
#include<vector>
#include<list>
#include<algorithm>
int main(){
    std::map<int,int>  result_map;
    std::vector<int> input;
    std::string str;
    input.push_back(1);
    input.push_back(2);
    input.push_back(4);
    input.push_back(3);
    int n=input.size();
    std::list<int> reverse;
    for(auto i:input){
        reverse.push_front(i);
    }
     int max=input.at(n-1);
    std::list<int>::const_iterator it=reverse.begin();
    for(it=reverse.begin();it!=reverse.end();it++){
            if(*it<max){
                result_map[*it]=max;
            }else{
                result_map[*it]=-1;
                max=*it;
            }
    }
    std::cout<<"Success"<<std::endl;
    for(auto pair:result_map){
        std::cout<<pair.first<<":"<<pair.second<<std::endl;
    }
    return 0;
}