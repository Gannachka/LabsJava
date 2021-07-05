function sendFile() {
		let fileSrc = document.getElementById("file").files[0];
		let fd = new FormData();
		fd.append("file", fileSrc);

		let xhr = new XMLHttpRequest();
		xhr.open("POST", "https://localhost:8080/Lab_23/Sss?fileName=" + (fileSrc.name), true)
		xhr.onreadystatechange = function () {
			if (this.readyState === 4) {
				if (this.status === 200)
					alert("Uploaded!");
				else
					alert(this.status + "\n" + this.statusText);
			}
		}
		xhr.send(fd);