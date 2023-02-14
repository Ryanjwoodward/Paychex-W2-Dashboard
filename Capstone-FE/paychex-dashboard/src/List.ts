class List<T> {
  private items : Array<T>;

  constructor(n? : number, defaultValue? : T){
    if ( n === undefined) {
      this.items = [];
    } else {
      if ( n && defaultValue){
        this.items = Array(n).fill(defaultValue);
      } else {
        this.items = Array(n);
      }
    }
  }

  push(item : T){
    this.items.push(item);
  }

  pop(item : T){
    return this.items.pop();
  }

  get(index : number) : T | undefined {
    return this.items[index];
  }

  set( index : number, item : T){
    this.items[index] = item;
  }

  getItems() : Array<T> {
    return this.items;
  }

}

List.prototype.toString = function listToString(){
  return JSON.stringify(this.getItems());
}

var list : List<string> = new List(5, "default");
list.set(1, "second");
list.set(0, "first");

console.log(list.toString());
