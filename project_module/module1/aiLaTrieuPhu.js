
class Question {
    constructor (id, name, answer, correctAnswer, point) {
        this.id = id;
        this.name = name;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
        this.point = point;
    }
}

let ques1 = new Question(1, 'Câu hỏi 1: Mồm bò mà không phải mồm bò. Đố là con gì', ['A. Con ốc sên', 'B. Con bò', 'C. Con mèo', 'D. Con ốc' ], 'A', 100);
let ques2 = new Question(2, 'Câu hỏi 2: Vừa bằng hạt đỗ, ăn giỗ cả làng. Là con gì?', ['A. Con rệp', 'B. Con ruồi', 'C. Con rắn', 'D. Con kiến' ], 'B', 200);
let ques3 = new Question(3, 'Câu hỏi 3: Tôi có 4 cái chân, 1 cái lưng nhưng không có cơ thể. Tôi là ai', ['A. Máy giặt', 'B. Điều hòa', 'C. Cái bàn', 'D. Ô tô' ], 'C', 300);
let ques4 = new Question(4, 'Câu hỏi 4: Nắng lửa mưa dầu tôi đâu bỏ bạn. Tối lửa tắt đèn sao bạn lại bỏ tôi. Đó là cái gì', ['A. Cái đèn', 'B. Cái giường', 'C. Cái mâm', 'D. Cái bóng' ], 'D', 400);
let ques5 = new Question(5, 'Câu hỏi 5: Vì tao tao phải đánh tao, vì tao tao phải đánh mày. Hỏi đang làm gì?', ['A. Đập muỗi', 'B. Rán cá', 'C. Quét sân', 'D. Lau nhà' ], 'A', 500);
let ques6 = new Question(6, 'Câu hỏi 6: Bàn gì xe ngựa sớm chiều giơ ra', ['A. Bàn là', 'B. Bàn cờ tướng', 'C. Bàn cờ vây', 'D. Bàn bạc' ], 'B', 600);
let ques7 = new Question(7, 'Câu hỏi 7: Bàn gì mà lại bước gần bước xa', ['A. Bàn tay', 'B. Bàn là', 'C. Bàn chân', 'D. Bàn tán' ], 'C', 700);
let ques8 = new Question(8, 'Câu hỏi 8: Mặt gì làm bãi chiến trường, Làm cho đổ máu, tan xương, cháy nhà?', ['A. Mặt trăng', 'B. Mặt bằng', 'C. Mặt trời', 'D. Mặt trận' ], 'D', 800);
let ques9 = new Question(9, 'Câu hỏi 9:  Ở nơi cao nhất trên đầu. Chẳng đen như tóc, lại màu đỏ tươi. Lúc khỏe đẹp như mặt trời. Đến khi đau yếu màu tươi xám dần. Là gì?', ['A. Cái mào của con gà trống', 'B. Tóc', 'C. Trái tim', 'D. Mặt trời' ], 'A', 900);
let ques10 = new Question(10, 'Câu hỏi 10: Tổng các số từ 1 đến 100', ['A. 5420', 'B. 5050', 'C. 4080', 'D. 4081' ], 'B', 1000);
let arrayQues = [ques1, ques2, ques3, ques4, ques5, ques6, ques7, ques8, ques9, ques10];
let countQuestion = 0;

let listPoint = [0];
for (let key in arrayQues) {
    listPoint.push(arrayQues[key].point);
}

function start () {
    showQuestion(countQuestion);
    startCountDown();
}

function showQuestion (i) {
    document.getElementById('questionID').innerHTML = arrayQues[i].name;
    document.getElementById('answer1ID').innerHTML = arrayQues[i].answer[0];
    document.getElementById('answer2ID').innerHTML = arrayQues[i].answer[1];
    document.getElementById('answer3ID').innerHTML = arrayQues[i].answer[2];
    document.getElementById('answer4ID').innerHTML = arrayQues[i].answer[3];
}

function checkAnswer (i) {
    let answer = document.getElementById('answer1ID').innerHTML;
    console.log(answer);
    if (i == arrayQues[countQuestion].correctAnswer) {
        alert('Correct Answer');
        countQuestion++;
        document.getElementById(`point${countQuestion}`).style.background = 'chartreuse';
        document.getElementById(`point${countQuestion-1}`).style.background = 'yellow';
    } else {
        alert('Wrong Answer');
        reload();
    }
    if (countQuestion == arrayQues.length) {
        alert('Congratulation! You are Millionaire.');
        alert('Your Money: ' + document.getElementById(`point${countQuestion}`).innerText) + '$';
    }
    showQuestion(countQuestion);
}

function reload () {
    window.location.reload();
}

function pointDisplay() {
    for (let i=listPoint.length-1; i>=0; i--) {
        document.getElementById('pointBoxID').innerHTML += 
        `
            <div class="boxPoint" id="point${i}">
               Câu số ${i}: ${listPoint[i]} $
            </div>
        `;
    }
}
pointDisplay();
function endGame () {
    if (countQuestion === 0) {
        alert('Sorry! You have 0$');
        reload();
    } else {
        alert('Congratulation! You have ' + listPoint[countQuestion] + '$');
        reload();
    }
}

function mouseMove (key) {
    document.getElementById(`answer${key}ID`).style.background = 'chartreuse';
}

function mouseOut (key) {
    document.getElementById(`answer${key}ID`).style.background = 'rgb(48, 204, 244)';
}


//         document.getElementById('countdownID').innerHTML = i;

function startCountDown () {
    let remainingTime = 100;

    // Hiển thị thời gian ban đầu
    document.getElementById('countdownID').innerHTML = remainingTime;

    // Sử dụng setInterval để đếm ngược
    let interval = setInterval(function() {
    remainingTime--;
    document.getElementById('countdownID').innerHTML = remainingTime;
    
    // Kiểm tra nếu thời gian còn lại bằng 0 thì dừng đếm ngược
    if (remainingTime === 0) {
        clearInterval(interval);
        document.getElementById('countdownID').innerHTML = "Hết giờ!";
        document.getElementById('countdownID').style.background = 'red';
    }
    }, 1000);
}



