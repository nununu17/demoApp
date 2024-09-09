window.onload = () => {
  
  const select = document.querySelector('select')
  
  const nameList = document.getElementsByClassName('name')
  
  const names = nameList.value
  
  const dispNameList = document.getElementsByClassName('dispName')
  
  const dispNames = dispNameList.value
  
  const toggle = (value, names, dispNames) => {
    
    for (let name of names){
      name.style.display = 'block';
    }
    
  };
  
  select.addEventListener('change', ()=> {
    
    toggle(event.target.value, name, dispName);
    
  }, false);
  
};