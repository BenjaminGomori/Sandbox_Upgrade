//
// window.onload = (event) => {
//     const webmks = document.querySelector('#mainCanvas');
//
//     webmks.style.position= "static";
//     webmks.style.scale= "1";
// };

const timeControl = document.querySelector('input[type="datetime-local"]');
const timeControlHidden = document.querySelector('.hid');

window.onload = (event) => {
    timeControl.value = timeControlHidden.value.replace(' ', 'T');
};

timeControl.addEventListener('change', (event) => {
    let date = new Date(timeControl.value);
    timeControlHidden.value = date.toISOString().slice(0, 19).replace('T', ' ');
});