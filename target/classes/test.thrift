# This will set the generated java class

namespace java com.test.thrift

typedef i32 int 

struct Item {
  1: i64 id,
  2: string content,
}

service TestService {
    i64 put(1:list<Item> items),
    int add(1:int n1, 2:int n2),
}

 