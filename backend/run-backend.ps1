$ErrorActionPreference = "Stop"
$backend = Split-Path -Parent $MyInvocation.MyCommand.Path
$tools = Join-Path $backend "tools"
$mavenVersion = "3.9.11"
$mavenHome = Join-Path $tools ("apache-maven-" + $mavenVersion)
$mavenZip = Join-Path $tools ("apache-maven-" + $mavenVersion + "-bin.zip")
if (-not (Test-Path (Join-Path $mavenHome "bin\mvn.cmd"))) {
    New-Item -ItemType Directory -Force -Path $tools | Out-Null
    if (-not (Test-Path $mavenZip)) {
        Write-Host "Downloading Maven $mavenVersion..."
        Invoke-WebRequest -Uri "https://archive.apache.org/dist/maven/maven-3/$mavenVersion/binaries/apache-maven-$mavenVersion-bin.zip" -OutFile $mavenZip
    }
    Write-Host "Extracting Maven..."
    Expand-Archive -Path $mavenZip -DestinationPath $tools -Force
}
Set-Location $backend
& (Join-Path $mavenHome "bin\mvn.cmd") spring-boot:run
