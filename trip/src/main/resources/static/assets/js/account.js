// 비동기 요청 처리를 위한 XMLHttpRequest 객체 선언.
var httpRequest1, httpRequest2;

window.onload = function () {
  let status = localStorage.getItem("IsLogin");
  if (status && status != "null") {
    console.log(status);
    document.querySelector(".header_nav_confirm_off").setAttribute("style", "display: none");    
    var settings = document.querySelectorAll(".header_nav_confirm_on");
        for (var i = 0; i < settings.length; i++) {
          settings[i].setAttribute("style", "display: ");
        }
  }

  let userInfo = JSON.parse(localStorage.getItem(status));
  console.log(userInfo);
  if (userInfo) {
    document.querySelector("#myuserid").value = userInfo.id;
    document.querySelector("#mypassword").value = userInfo.password;
    document.querySelector("#myname").value = userInfo.name;
    document.querySelector("#myemail").value = userInfo.email;
    document.querySelector("#myage").value = userInfo.age;
  }

  let nArticle = localStorage.getItem("nArticle");
  
  for (var i = 1; i <= nArticle; i++) {
    const article = JSON.parse(localStorage.getItem("article" + i));
    if (article) {
      
    }
  }
};

function programmingBook() {
  // 서버로부터 data를 전부 받은 상태 (Completed)
  if (httpRequest1.readyState == 4) {
    // 서버로부터의 응답 상태 (OK)
    if (httpRequest1.status == 200) {
      // 서버에서 응답 온 data를 XML로 받음.
      var books = httpRequest1.responseXML;
      // xml에서 책목록을 배열로 받음.
      var booklist = books.querySelectorAll("book");
      var len = booklist.length;
      var bookView = "";
      for (var i = 0; i < len; i++) {
        var book = booklist[i];
        var isbn = book.querySelector("isbn").childNodes[0].nodeValue; // xml에서 isbn 얻기
        var title = book.querySelector("title").childNodes[0].nodeValue; // xml에서 제목 얻기
        var price = book.querySelector("price").childNodes[0].nodeValue; // xml에서 가격 얻기
        var desc = book.querySelector("description").childNodes[0].nodeValue; // xml에서 설명 얻기
        // 책의 갯수만큼 화면구성
        bookView += '<div class="col-md-3 border border-secondary rounded pt-2 pb-2">';
        bookView += ' <div class="mt-1">';
        bookView += '   <img src="img/book/' + isbn + '.png" class="rounded w-100" title="' + desc + '" alt="" />';
        bookView += " </div>";
        bookView += ' <div class="mt-1 p-1 text-center" style="background-color: #f2f2f2;">';
        bookView += "<h6>" + title + "<br />(" + numberWithCommas(price) + "원)</h6>";
        bookView += " </div>";
        bookView += "</div>";
      }
      // 아이디가 plist인 div에 책화면을 html로 삽입.
      document.querySelector("#plist").innerHTML = bookView;
    }
  }
}

function essayBook() {
  // 서버로부터 data를 전부 받은 상태 (Completed)
  if (httpRequest2.readyState == 4) {
    // 서버로부터의 응답 상태 (OK)
    if (httpRequest2.status == 200) {
      // 서버에서 응답 온 data를 text로 받음.
      var books = httpRequest2.responseText;
      // 위의 text를 JSON객체로 변환.
      var booklist = JSON.parse(books);
      var len = booklist.length;
      var bookView = "";
      for (var i = 0; i < len; i++) {
        var book = booklist[i];
        bookView += '<div class="col-md-3 border border-secondary rounded pt-2 pb-2">';
        bookView += ' <div class="mt-1">';
        bookView +=
          '   <img src="img/book/' + book.isbn + '.png" class="rounded w-100" title="' + book.description + '" />';
        bookView += " </div>";
        bookView += ' <div class="mt-1 p-1 text-center" style="background-color: #f2f2f2;">';
        bookView += "<h6>" + book.title + "<br />(" + numberWithCommas(book.price) + "원)</h6>";
        bookView += " </div>";
        bookView += "</div>";
      }
      // 아이디가 elist인 div에 책화면을 html로 삽입.
      document.querySelector("#elist").innerHTML = bookView;
    }
  }
}

// 정규표현식을 이용한 3자리마다 ,(comma) 찍기(가격)
function numberWithCommas(x) {
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

// 투표 시작일과 종료일 날짜 형식. (yy.mm.dd)
function dateFormat(date) {
  var yymmdd = date.split("-");
  return yymmdd[0].substr(2, 2) + "." + yymmdd[1] + "." + yymmdd[2];
}

// 로그인
function login() {
  let id = document.getElementById("userid").value;
  let password = document.getElementById("password").value;
  let index = localStorage.getItem("nMember");
  if (!index)
    index = 1;
  
  for (var i = 1; i <= index; i++) {
    const user = JSON.parse(localStorage.getItem("user" + i));
    if (user) {
      if (
        user.id &&
        user.password &&
        user.id === id &&
        user.password === password
      ) {
        alert("로그인 성공!");
        localStorage.setItem("IsLogin", "user" + i);
        document.querySelector(".header_nav_confirm_off").style.display = "none";
        document.querySelector(".header_nav_confirm_on").setAttribute("style", "display: ");
        var settings = document.querySelectorAll(".header_nav_confirm_on");
        for (var i = 0; i < settings.length; i++) {
          settings[i].setAttribute("style", "display: ");
        }
        
        window.location.replace("index.html");
        break;
      }
    }
    if (i == index) {
      alert("아이디와 비밀번호를 확인해주세요!");
    }
  }
}

// 로그아웃
function logout() {
  // id가 profile_img인 element의 src 속성의 값을 img/noimg.png로 설정.
  localStorage.setItem("IsLogin",null);
  document.querySelector(".header_nav_confirm_on").setAttribute("style", "display: none");
  document.querySelector(".header_nav_confirm_off").style.display = "";
}

//투표하기
function poll() {
  var votes = document.querySelectorAll('input[name="vote_answer"]');
  var sel_menu = "";

  for (var i = 0; i < votes.length; i++) {
    if (votes[i].checked) {
      sel_menu = votes[i].value;
      break;
    }
  }
  alert(sel_menu + "를 선택했습니다.");
}

// 투표만들기
function pollMake() {
  // pollmake.html의 창아이디를 poll로 설정하고 가로 500, 세로 300인 창을 열기.
  window.open("pollmake.html", "poll", "width=500,height=300,top=300,left=400");
}

// 답변 항목 추가
function addArticle() {
  let author = document.getElementById("author").value;
  let title = document.getElementById("title").value;
  let comment = document.getElementById("comment").value;

  if (!author || !title || !comment) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    const article = {
      author: author,
      title: title,
      comment: comment,
    };

    let index = localStorage.getItem("nArticle");

    if (index == null) { index = 1; }
    else index++;
      
    localStorage.setItem("nArticle", index);
    localStorage.setItem("article" + index, JSON.stringify(article));
  }
    // alert("게시글이 작성됐습니다.");

    // var listTbody = document.querySelector("tbody");

    // var trEl = document.createElement("tr"); // <tr></tr>
    // var tdE1 = document.createElement("td"); // <tr></tr>
    // tdE1.setAttribute("value", index+3); // 게시글이 3개 있는데, 로컬엔 저장안되어 있어서 +3하여 시작
    // var tdE2 = document.createElement("td"); // <tr></tr>
    // var aE2 = document.createElement("a");
    // aE2.setAttribute("href", "view.html");
    // aE2.setAttribute("value", title);
    // tdE2.appendChild(aE2); // td에 a태그 추가
    // var tdE3 = document.createElement("td"); // <tr></tr>
    // tdE3.setAttribute("value", author);

    // trE1.appendChild(tdE1);
    // trE1.appendChild(tdE2);
    // trE1.appendChild(tdE3);

    // listTbody.appendChild(trE1);
}

// 투표 생성
function makePoll() {
  var sdate = document.querySelector("#start_date").value; // 시작일.
  var edate = document.querySelector("#end_date").value; // 종료일.
  if (!sdate || !edate) {
    // 시작, 종료일 유효성검사.
    alert("설문 기간 입력!!!");
    return;
  }

  var quest = document.querySelector("#question").value; // 질문.
  if (!quest) {
    // 질문 유효성검사.
    alert("질문 내용 입력!!!");
    return;
  }

  var answerInput = document.querySelectorAll('input[name="answer"]'); // 답변 항목.
  for (var i = 0; i < answerInput.length; i++) {
    // 답변항목 유효성검사.
    if (!answerInput[i].value) {
      alert("답변 항목 입력!!!");
      return;
    }
  }

  var answers = [];
  for (var i = 0; i < answerInput.length; i++) {
    answers.push(answerInput[i].value); // 답변 배열에 입력 data 넣기.
  }

  // 입력 data를 이용하여 JSON객체 생성.
  var poll = {
    start_date: sdate,
    end_date: edate,
    question: quest,
    answers: answers
  };

  var poll_json = JSON.stringify(poll); // JSON객체를 문자열 변환.

  localStorage.setItem("poll", poll_json); // localStorage에 넣기.

  alert("투표를 생성합니다.");

  document.location.reload(); // 부모창 새로고침.  
}

////////////////////////////////////

function regist() {
  let id = document.getElementById("newid").value;
  let password = document.getElementById("newpassword").value;
  let name = document.getElementById("newname").value;
  let email = document.getElementById("newemail").value;
  let age = document.getElementById("newage").value;

  if (!id || !password || !name || !email || !age) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    const user = {
      id: id,
      password: password,
      name: name,
      email: email,
      age: age,
    };

    let index = localStorage.getItem("nMember");

    if (index == null) { index = 1; }
    else index++;
      
    localStorage.setItem("nMember", index);
    localStorage.setItem("user" + index, JSON.stringify(user));
    alert("사용자 등록 성공!");
    
  }
}

function modify() {
  let id = document.getElementById("myuserid").value;
  let password = document.getElementById("mypassword").value;
  let name = document.getElementById("myname").value;
  let email = document.getElementById("myemail").value;
  let age = document.getElementById("myage").value;

  if (!id || !password || !name || !email || !age) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    const user = {
      id: id,
      password: password,
      name: name,
      email: email,
      age: age,
    };

    let status = localStorage.getItem("IsLogin");
    localStorage.setItem(status, JSON.stringify(user));
    alert("사용자 정보 수정 성공!");
  }
  window.location.reload();
}

function remove() {
    let status = localStorage.getItem("IsLogin");
    localStorage.removeItem(status);
  alert("탈퇴 성공!");
  
  logout();
  window.location.replace("index.html");
}

function save() {
  let author = document.getElementById("author").value;
  let title = document.getElementById("title").value;
  let comment = document.getElementById("comment").value;

  if (!author || !title || !comment) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    const article = {
      author: author,
      title: title,
      comment: comment,
    };

    localStorage.setItem("nArticle", 3);
    let index = localStorage.getItem("nArticle");

    if (index == null) { index = 1; }
    else index++;
      
    localStorage.setItem("nArticle", index);
    localStorage.setItem("article" + index, JSON.stringify(article));

    alert("게시글이 작성됐습니다.");

    var listTbody = document.querySelector("tbody");    
    
    // 게시글의 index+1 만큼 인덱스를 가지면 됩니다.
    listTbody.innerHTML += `<tr class="removeArticle${index}"><td>${index}</td><td><a href="view.html">${title}</a></td><td>${author}</td></tr>`;
    console.log(listTbody);
  }
}

function removeArticle(){
  let index = localStorage.getItem("nArticle");

  // 예외처리
  if (index == null) {
    alert("게시글이 없어서 삭제할 수 없습니다.")
    return;
  }

  // 게시글의 length 인덱스를 가지고있는 tr을 삭제하면 됩니다.
  var removeObj = document.querySelector(`.removeArticle${index}`);    
  var listTbody = document.querySelector("tbody");    
  listTbody.removeChild(removeObj);

  

  alert("게시글이 삭제됐습니다.");
  localStorage.setItem("nArticle", --index);
  localStorage.setItem("article" + index, JSON.stringify(article));

}

function modifyArticle() {
  let author = document.getElementById("author").value;
  let title = document.getElementById("title").value;
  let comment = document.getElementById("comment").value;

  if (!author || !title || !comment) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    const article = {
      author: author,
      title: title,
      comment: comment,
    };


    alert("게시글이 수정됐습니다.");
    document.querySelector("#article-author").innerText = author;
    document.querySelector("#article-title").innerText = title;
    document.querySelector("#article-context").innerText = comment;
  }
}