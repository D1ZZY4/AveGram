const http = require('http');
const fs = require('fs');
const path = require('path');

const PORT = 5000;
const HOST = '0.0.0.0';

const html = fs.readFileSync(path.join(__dirname, 'index.html'), 'utf8');

http.createServer((req, res) => {
  res.writeHead(200, {
    'Content-Type': 'text/html; charset=utf-8',
    'Cache-Control': 'no-store, no-cache, must-revalidate',
  });
  res.end(html);
}).listen(PORT, HOST, () => {
  console.log(`AveGram info page serving on http://${HOST}:${PORT}`);
});
