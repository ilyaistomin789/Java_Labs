let ws;
const startSendMessage = () => {
    if (ws == null) {
        ws = new WebSocket('ws://localhost:8080/java_15/websocket');
        ws.onopen = () => {
            console.log('Connection was opened')
        }
        ws.onclose = (s) => {
            console.log('Connection was closed', s);
        }
        ws.onmessage = (message) => {
            document.getElementById('textarea').innerHTML += `\n${message.data}`;
        }
        document.getElementById('startButton').disabled = true;
        document.getElementById('stopButton').disabled = false;
    }
}
const stopSendMessage = () => {
    ws.close(3001, 'Stop application');
    ws = null;
    document.getElementById('startButton').disabled = false;
    document.getElementById('stopButton').disabled = true;
}