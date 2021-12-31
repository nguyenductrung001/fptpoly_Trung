var student = {
    name: "My name",
    age: 99,
    address: "Don Nguyen 5, Nguyen Co Thach, Ha Noi",
    subjects: [{ name: "Javascript", point: 10 }]
};
const addSubject = function() {
    let name = document.getElementById("name").value;
    let point = document.getElementById("point").value;
    student.subjects.push({ name: name, point: point });
};
const showInfo = function() {
    const info = Array.from(document.querySelectorAll(".unit>p"));
    const subjects = document.getElementById("subject");
    console.log(info);
    console.log(subjects);
    info[0].innerHTML = `Ho Ten: ${student.name}`;
    info[1].innerHTML = `Tuoi: ${student.age}`;
    info[2].innerHTML = `Dia chi: ${student.address}`;
    subjects.innerHTML = "";
    student.subjects.forEach(subject => {
        subjects.innerHTML += `<li>Mon hoc: ${subject.name}. Diem: ${
        subject.point
      }</li>`;
    });
};
showInfo();
window.add = function() {
    addSubject();
    showInfo();
};